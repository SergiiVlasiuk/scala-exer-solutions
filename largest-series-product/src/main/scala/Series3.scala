import scala.util.Try

object Series3 {
  def slices(n: Int, digits: String): List[List[Int]] =
    digits.toList.map(_.asDigit).sliding(n).toList

  def largestProduct(n: Int, digits: String): Option[Int] = {
    val valid = Try[Boolean](isValid(n, digits))
    if (valid.isSuccess) {
      if (n == 0) Some(1) else Some(slices(n, digits).map(_.product).max)
    } else None
  }

  private def isValid(n: Int, digits: String): Boolean = {
    require(n >= 0)
    require(digits.length >= n)
    require(digits.forall(_.isDigit))
    true
  }
}