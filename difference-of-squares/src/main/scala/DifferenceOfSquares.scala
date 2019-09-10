import scala.math.pow

object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int = (1 to n).map(x => x * x).sum

  def squareOfSum(n: Int): Int = pow((1 to n).sum, 2).toInt

  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)
}
