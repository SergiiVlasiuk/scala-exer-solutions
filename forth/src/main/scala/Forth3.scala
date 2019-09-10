import ForthError.ForthError

class Forth3 extends ForthEvaluator {

  case class ForthResult(r: Seq[Int]) extends ForthEvaluatorState {
    override lazy val toString = r.mkString(" ")
  }

  sealed trait ForthOperation {
    def eval(ns: Seq[Int]): Either[ForthError, Seq[Int]]
  }
  sealed abstract class BuiltinForthOperation(val name: String)(invalid: Seq[Int] => Boolean)(evaluate: Seq[Int] => Seq[Int]) extends ForthOperation {
    final override def eval(ns: Seq[Int]): Either[ForthError, Seq[Int]] =
      if (invalid(ns)) Left(ForthError.UnknownWord)
      else Right(evaluate(ns))
  }
  case class NumericForthOperation(name: String, args: Seq[Int]) extends ForthOperation {
    override def eval(ns: Seq[Int]): Either[ForthError, Seq[Int]] = Right(args)
  }
  case class Alias(name: String, ops: Seq[ForthOperation]) extends ForthOperation {
    override def eval(ns: Seq[Int]): Either[ForthError, Seq[Int]] = ops.foldLeft(Right(ns): Either[ForthError, Seq[Int]]) {
      case (Right(acc), next) => next.eval(acc)
      case (left, _)          => left
    }
  }

  object ForthOperation {
    lazy val values = Seq(Plus, Minus, Times, Div, Dup, Drop, Swap, Over)

    def find(raw: String): Option[ForthOperation] = values.find(_.name equalsIgnoreCase raw)

    case object Plus extends BuiltinForthOperation("+")(_.size < 2)(ns => ns.dropRight(2) :+ ns.takeRight(2).sum)
    case object Minus extends BuiltinForthOperation("-")(_.size < 2)({ ns =>
      val them = ns.takeRight(2)
      ns.dropRight(2) :+ them.head - them.last
    })
    case object Times extends BuiltinForthOperation("*")(_.size < 2)({ ns =>
      val them = ns.takeRight(2)
      ns.dropRight(2) :+ them.head * them.last
    })
    case object Div extends BuiltinForthOperation("/")(it => it.size < 2 || it.last == 0)({ ns =>
      val them = ns.takeRight(2)
      ns.dropRight(2) :+ them.head / them.last
    })
    case object Dup extends BuiltinForthOperation("dup")(_.isEmpty)(ns => ns :+ ns.last)
    case object Drop extends BuiltinForthOperation("drop")(_.isEmpty)(_.dropRight(1))
    case object Swap extends BuiltinForthOperation("swap")(_.size < 2)({ ns =>
      val them = ns.takeRight(2)
      ns.dropRight(2) :+ them.last :+ them.head
    })
    case object Over extends BuiltinForthOperation("over")(_.size < 2)(ns => ns :+ ns.takeRight(2).min)
  }

  implicit class RicherString(s: String) {
    def asInt: Option[Int] = scala.util.Try(s.toInt).toOption
  }

  def eval(text: String): Either[ForthError, ForthEvaluatorState] = {
    lazy val (rawAliases, rawCommands) = text.split(";").map(_.trim).partition(_.startsWith(":"))

    val potentialAliases = rawAliases.foldLeft(Right(Map()): Either[ForthError, Map[String, ForthOperation]]) {
      case (error @ Left(_), _) => error
      case (Right(acc), raw)    =>
        val tokens = raw.split(" ").drop(1)
        val name = tokens.head
        val args = tokens.drop(1)
        if (name.forall(_.isDigit)) Left(ForthError.InvalidWord)
        else if (args.forall(_.forall(_.isDigit))) Right(acc.updated(name, NumericForthOperation(name, args.map(_.toInt))))
        else Right(acc.updated(name, Alias(name, args.flatMap(arg => acc.get(arg) orElse ForthOperation.find(arg)))))
    }

    potentialAliases.right.flatMap { aliases =>
      rawCommands.head.split(" ").foldLeft(Right(Seq()): Either[ForthError, Seq[Int]]) {
        case (Right(acc), next) => next.asInt match {
          case Some(it) => Right(acc :+ it)
          case _        =>
            (aliases.get(next) orElse ForthOperation.find(next)) match {
              case Some(command) => command.eval(acc)
              case _             => Left(ForthError.UnknownWord)
            }
        }
        case _ => Left(ForthError.UnknownWord)
      }
    }.right.map(is => ForthResult(is))
  }
}