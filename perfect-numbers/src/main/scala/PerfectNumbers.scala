import scala.util.Either

object PerfectNumbers {
  def classify(number: Int): Either[String, NumberType] = {
    if (number <= 0) Left("Classification is only possible for natural numbers.")
    else {
      println(s"number=$number factors(number)" + factors(number) + " sum is " + factors(number).sum)
      factors(number).sum match {
        case p if p == number => Right(NumberType.Perfect)
        case a if a > number => Right(NumberType.Abundant)
        case _ => Right(NumberType.Deficient)
      }
    }
  }

  private def factors(num: Int): IndexedSeq[Int] = (1 to num / 2).filter {
    num % _ == 0
  }
}


sealed abstract class NumberType

object NumberType {

  case object Perfect extends NumberType

  case object Abundant extends NumberType

  case object Deficient extends NumberType

}