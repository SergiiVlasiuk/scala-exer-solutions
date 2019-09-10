import scala.util.Try

object Series {
  def largestProduct(product: Int, digits: String): Option[Int] = product match {
    case 0 => Some(1)
    case _ if Try[Boolean](isValid(product, digits)) isFailure => None
    case _ => Some(digits.map(_.asDigit).sliding(product).map(_.product).max)
  }

  private def isValid(product: Int, digits: String):Boolean = {
    require(product >= 0)
    require(digits.length >= product)
    require(digits.forall(_.isDigit))
    true
  }
}
