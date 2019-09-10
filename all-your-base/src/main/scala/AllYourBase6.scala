import scala.annotation.tailrec
import scala.util.Try

object AllYourBase6 {
  def rebase(baseA: Int, digits: List[Int], baseB: Int): Option[List[Int]] = {
    val valid = Try[Boolean](isValid(baseA, digits, baseB))
    if (valid.isSuccess) {
      val number = toBase10(baseA, digits)
      Some(base10ToBaseB(number, baseB))
    } else None
  }

  private def isValid(baseA: Int, digits: List[Int], baseB: Int): Boolean = {
    require(baseA > 1)
    require(baseB > 1)
    require(digits.forall(i => 0 <= i && i < baseA))
    true
  }

  private def toBase10(base: Int, digits: List[Int]): Int = {
    digits.foldLeft(0)((acc, i) => acc * base + i)
  }

  private def base10ToBaseB(number: Int, baseB: Int): List[Int] = {
    def getPositions = Stream.iterate(1)(_ * baseB)
      .takeWhile(_ <= number)
      .toList
      .reverse

    @tailrec
    def loop(result: List[Int], residue: Int, positions: List[Int]): List[Int] = positions match {
      case Nil => result
      case h :: tail => loop(result :+ (residue / h), residue % h, tail)
    }

    val result = loop(Nil, number, getPositions)
    if (result.isEmpty) List(0) else result
  }
}
