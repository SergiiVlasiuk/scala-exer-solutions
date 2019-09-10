import Triangle5._
import Triangle5Type._

case class Triangle5(side1: Side, side2: Side, side3: Side) {

  lazy val triangleType: Triangle5Type = {
    if (!isLogical) Illogical
    else equalSides match {
      case 3 => Equilateral
      case 2 => Isosceles
      case _ => Scalene
    }
  }

  private def equalSides: Int =
    4 - Set(side1, side2, side3).size

  private def isLogical: Boolean = {
    val sidesMustBeGreaterThanZero = side1 > 0 && side2 > 0 && side3 > 0
    val sumOfTwoSidesMustBeGreaterThatThirdSide =
      side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2

    sidesMustBeGreaterThanZero && sumOfTwoSidesMustBeGreaterThatThirdSide
  }
}

object Triangle5 {
  type Side = Int
}

object Triangle5Type {
  sealed trait Triangle5Type
  object Equilateral extends Triangle5Type
  object Isosceles extends Triangle5Type
  object Scalene extends Triangle5Type
  object Illogical extends Triangle5Type
}