import ForthError._

import scala.collection.mutable.{Map => MMap, Stack => MStack}
import scala.util.matching.Regex

object Forth2 {
  type Result = Either[ForthError, Forth2#State]
  val lineSep = ";(?:\r|\n)?"
  val tokSep = raw"(?:\s|\u0000|\u0001| )+"
  val numRE: Regex = raw"([0-9]+)".r
  val opRE: Regex = raw"([*/+-])".r
  val comRE: Regex = raw"(drop|dup|over|swap)".r
}

import Forth2._

class Forth2 {

  case class State(stack: List[Int]) {
    override def toString: String = stack.reverse.mkString(" ")
  }

  def eval(expStr: String): Result = {
    val comMap =
      MMap("dup" -> "dup", "drop" -> "drop", "over" -> "over", "swap" -> "swap")
    val rstack = MStack[Int]()
    val expLines = expStr.toLowerCase.split(lineSep)
    if (expLines.size == 1 && expLines(0) == "") return Right(State(Nil))
    for (expLine <- expLines) {
      val expLineTrim = expLine.trim
      val res = {
        if (expLineTrim(0) == ':') defineWord(expLineTrim)
        else calculate(expLineTrim)
      }
      res match {
        case Left(error) => return Left(error)
        case _ => // next expLine
      }
    }

    // inside eval()
    def calculate(expLineTrim: String): Result = {
      val expToks = expLineTrim.split(tokSep)

      expToks.foreach {
        case numRE(num) => rstack.push(num.toInt)
        case opRE(op) =>
          if (rstack.size < 2) return Left(StackUnderflow)
          val (n1, n0) = (rstack.pop, rstack.pop)
          op match {
            case "+" => rstack.push(n0 + n1)
            case "-" => rstack.push(n0 - n1)
            case "*" => rstack.push(n0 * n1)
            case "/" =>
              if (n1 == 0) return Left(DivisionByZero)
              rstack.push(n0 / n1)
          }
        case comRE(com) =>
          handleCom(comMap(com)) match {
            case Left(error) => return Left(error)
            case Right(state) =>
          }
        case word =>
          if (!comMap.contains(word)) return Left(InvalidWord)
          val com = comMap(word)
          calculate(com)
      }

      return Right(State(rstack.toList))
    } // end of calculate()

    // inside eval()
    def handleCom(com: String): Result = {
      com match {
        case "drop" =>
          if (rstack.size < 1) return Left(StackUnderflow)
          rstack.pop
        case "dup" =>
          if (rstack.size < 1) return Left(StackUnderflow)
          rstack.push(rstack.head)
        case "over" =>
          if (rstack.size < 2) return Left(StackUnderflow)
          rstack.push(rstack(1))
        case "swap" =>
          if (rstack.size < 2) return Left(StackUnderflow)
          val top = rstack.pop
          val sec = rstack.pop
          rstack.push(top).push(sec)
      }
      return Right(State(rstack.toList))
    } // end of handleCom()

    // inside eval()
    def defineWord(exp: String): Result = {
      val toks = exp.split(tokSep)
      if (toks(0) != ":") return Left(UnknownWord)
      toks(1) match {
        case numRE(num) => return Left(InvalidWord)
        case newWord =>
          comMap(newWord) = toks.drop(2).mkString(" ")
      }
      Right(State(rstack.toList))
    } // end of defineWord()

    return Right(State(rstack.toList))
  } // end of eval()
} // end of class Forth2
