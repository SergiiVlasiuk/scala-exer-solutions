class Triangle4(x: Int, y: Int, z: Int) {
  import TriangleType._

  lazy val triangleType: TriangleType = uniqSides match {
    case Some(1) => Equilateral
    case Some(2)  => Isosceles
    case Some(3) => Scalene
    case _ => Illogical
  }

  private lazy val uniqSides: Option[Int] = {
    if (isValid) Some(Set(x, y, z) size) else None
  }

  private lazy val isValid = {
    val sortedSides = Vector(x, y, z).sorted
    (sortedSides take(2) sum) > (sortedSides last) && (sortedSides forall(_ > 0))
  }
}

object TriangleType {
  sealed trait TriangleType
  case object Scalene extends TriangleType
  case object Isosceles extends TriangleType
  case object Equilateral extends TriangleType
  case object Illogical extends TriangleType
}

object Triangle4 {

  def apply(x: Int, y: Int, z: Int) = {
    new Triangle4(x, y, z)
  }
}