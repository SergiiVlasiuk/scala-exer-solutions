case class Triangle2(a: Double, b: Double, c: Double) {
  lazy private val isValid: Boolean = !(a + b < c || a + c < b || b + c < a) && Set(a, b, c).min > 0

  def equilateral: Boolean = isValid && Set(a, b, c).size == 1

  def isosceles: Boolean = isValid && Set(a, b, c).size <= 2

  def scalene: Boolean = isValid && Set(a, b, c).size == 3
}


//class Triangle2(x: Double, y: Double, z: Double) {
//  import TriangleType._
//
//  lazy val triangleType: TriangleType = uniqSides match {
//    case Some(1) => Equilateral
//    case Some(2)  => Isosceles
//    case Some(3) => Scalene
//    case _ => Illogical
//  }
//
//  private lazy val uniqSides: Option[Int] = {
//    if (isValid) Some(Set(x, y, z) size) else None
//  }
//
//  private lazy val isValid = {
//    val sortedSides = Vector(x, y, z).sorted
//    (sortedSides take(2) sum) > (sortedSides last) && (sortedSides forall(_ > 0))
//  }
//}
//
//object TriangleType {
//  sealed trait TriangleType
//  case object Scalene extends TriangleType
//  case object Isosceles extends TriangleType
//  case object Equilateral extends TriangleType
//  case object Illogical extends TriangleType
//}
//
//object Triangle2 {
//
//  def apply(x: Double, y: Double, z: Double) = {
//    new Triangle2(x, y, z)
//  }
//}


//case class Triangle2(a: Double, b: Double, c: Double) {
//
//  def triangleType: TriangleType.Type = {
//    if(!isLogical) TriangleType.Illogical
//    else {
//      Set(a, b, c).size match {
//        case 1 => TriangleType.Equilateral
//        case 2 => TriangleType.Isosceles
//        case 3 => TriangleType.Scalene
//      }
//    }
//  }
//
//  private def isLogical = {
//    val isPositive = a > 0 && b > 0 && c > 0
//    val sums = a + b >= c && a + c >= b && b + c >= a
//    isPositive && sums
//  }
//
//}
//
//object TriangleType {
//  trait Type
//  object Equilateral extends Type
//  object Isosceles extends Type
//  object Scalene extends Type
//  object Illogical extends Type
//}
