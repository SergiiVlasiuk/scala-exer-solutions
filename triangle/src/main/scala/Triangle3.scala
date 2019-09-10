case class Triangle3(a: Double, b: Double, c: Double) {
  private val sides = List(a, b, c)
  private val legal = sides.max * 2 < sides.sum
  private val distinctSides = sides.distinct.size

  val equilateral: Boolean = legal && distinctSides == 1
  val isosceles: Boolean = legal && distinctSides <= 2
  val scalene: Boolean = legal && distinctSides == 3
}