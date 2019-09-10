import scala.annotation.tailrec
import scala.util.parsing.combinator.RegexParsers

object Alphametics extends RegexParsers {
  private val constant: Parser[Int] = """\-?\d+""".r ^^ { value => value.toInt }
  private val word: Parser[String] = """\w+""".r

  private def expr: Parser[(List[String], String)] = word ~ rep("+" ~ word) ~ "==" ~ word ^^ {
    case w ~ list ~ _ ~ r => (w :: list.map(_._2), r)
  }

  private def calculate(value: ParseResult[(List[String], String)]) = value match {
    case x if !x.successful => None
    case x: Success[(List[String], String)] if x.result._1.exists(v => v.length > x.result._1.length) => None
    case x: Success[(List[String], String)] =>
      val res = x.result
      val list = res._1.map(_.reverse.zipWithIndex.toList)
      val tuples = res._2.reverse.zip(list)
      tuples.foreach(println)
      x
    case _ => None
  }

  def main(args: Array[String]): Unit = {
    //    val text = "ACA + DD == BD"
    //    val text = "AS + A == MOM"
    val text = "A + A + A + A + A + A + A + A + A + A + A + B == BCC"
    val letters = text.toSet.filter(x => x.isLetter)
    val res = parseAll(expr, text)
    val residual = 10 / 10
    println(s"\n$res")
    calculate(res)
    println(s"${digits.take(20).toList}")
    println(s"${digits.take(10).toList}")
    println(s"${digits.take(30).toList}")
  }

  private val digits = Stream.iterate(0, 10)(_ + 1)

  /**
    * injections from {1,2,...,p} to {1, 2, ... n}, n >= p
    */
  private def generateInjections(p: Int, f: Stream[Int]): Stream[List[Int]] =
    if (p == 1) f.map(List(_))
    else {
      for {
        x <- f
        newF = f.filter(_ != x)
        pgi = generateInjections(p - 1, newF)
        a <- pgi
      } yield x :: a
    }

  //  def solve(expression: String): Option[Map[Char, Int]] = ???
  def solve(expression: String): Option[Map[Char, Int]] = {

    val letters = expression.toSet.filter(x => x.isLetter)
    val (terms, result) = {
      val expr01 = expression.split(" == ")
      (expr01(0).split(" \\+ ").toList, expr01(1))
    }
    val firstChars = {
      val r = result.charAt(0) :: terms.map(_.charAt(0))
      r.toSet
    }

    def isSolution(candidate: Map[Char, Int]): Boolean = {
      val sum = terms.map(s => s.foldLeft("")((acc, c) => acc + candidate(c))).map(_.toLong).sum
      val r = result.foldLeft("")((acc, c) => acc + candidate(c)).toLong
      sum == r
    }

    @tailrec
    def loop(mp: Stream[Map[Char, Int]]): Option[Map[Char, Int]] = mp match {
      case Stream() => None
      case h #:: tail => if (isSolution(h)) Some(h) else loop(tail)
    }

    val stream = generateInjections(letters.size, digits).toList
    loop {
      generateInjections(letters.size, digits).map(letters.toStream.zip(_))
        .map(_.toMap)
        .filter(x => firstChars.forall(x(_) != 0))
    }.map(m => Map(m.toSeq.sortBy(_._1): _*))
  }
}
