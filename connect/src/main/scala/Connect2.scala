import Color2.Color2

object Color2 {
  sealed trait Color2
  case object White extends Color2
  case object Black extends Color2
  case object Blank extends Color2
}

case class Connect2(_in: Seq[String]) {
  def winner:Option[Color2] = ???

  import Color2._

  case class Pos(x: Int, y: Int)

  val in: Seq[Seq[Color2]] = _in.map(_.map {
    case 'X' => Black
    case 'O' => White
    case _ => Blank
  })

  val width = in.head.length
  val height = in.length

  lazy val result: Option[Color2] = {
    val startOfWhite = (0 until width).map(Pos(0, _)).filter(isPlacedOnBoard(White))
    lazy val startOfBlack = (0 until height).map(Pos(_, 0)).filter(isPlacedOnBoard(Black))

    val whiteWin = traverse(White, startOfWhite)(whiteArrived)
    lazy val blackWin = traverse(Black, startOfBlack)(blackArrived)

    whiteWin.orElse(blackWin)
  }

  def isPlacedOnBoard(c: Color2)(pos: Pos): Boolean = in(pos.x)(pos.y) == c

  def whiteArrived(pos: Pos): Boolean = pos.x == height-1
  def blackArrived(pos: Pos): Boolean = pos.y == width-1

  def traverse(c: Color2, placed: Seq[Pos], visited: Set[Pos] = Set.empty)(p: (Pos) => Boolean): Option[Color2] = {
    val adjacentPos = placed.flatMap(adjacent).filter { p =>
      !visited.contains(p) && isPlacedOnBoard(c)(p)
    }

    if (adjacentPos.exists(p)) Option(c)
    else if (adjacentPos.isEmpty) None
    else traverse(c, adjacentPos, visited ++ adjacentPos)(p)
  }

  def adjacent(pos: Pos): Vector[Pos] = {
    val Pos(x, y) = pos

    Vector(
      Pos(x-1, y-1), Pos(x, y-1),  Pos(x+1, y-1),
      Pos(x-1, y),   pos,          Pos(x+1, y),
      Pos(x-1, y+1), Pos(x, y+1),  Pos(x+1, y+1)
    ).filter { case Pos(x, y) => x > -1 && x < height && y > -1 && y < width }
  }
}