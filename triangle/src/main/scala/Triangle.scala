case class Triangle(a: Double, b: Double, c: Double) {
  private val sides = List(a, b, c).sorted reverse
  private lazy val validSides = {
    val allSidesPositive = sides.count(i => i <= 0).equals(0)
    val validLengths = sides.tail.sum > sides.head
    allSidesPositive && validLengths
  }

  def equilateral: Boolean = validSides && sides.distinct.size == 1

  def isosceles: Boolean = validSides && sides.distinct.size <= 2

  def scalene: Boolean = validSides && sides.distinct.size == 3
}
