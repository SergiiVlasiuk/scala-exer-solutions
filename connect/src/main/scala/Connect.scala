sealed trait Color

object Color {
  case object White extends Color

  case object Black extends Color
}

case class Vertex(char: Char, x: Int, y: Int, neighbors: Seq[(Int, Int)] = Seq()) {
  val color: Option[Color] = char match {
    case 'X' => Some(Color.Black)
    case 'O' => Some(Color.White)
    case _ => None
  }
}

case class Connect(lines: Seq[String]) {
  lazy val h = lines.size
  lazy val w = lines.head.size
  lazy val board = lines.zipWithIndex.flatMap { case (row, y) =>
    row.zipWithIndex.map { case (value, x) =>
      val neighbors = Seq((x - 1, y), (x + 1, y), (x, y + 1), (x, y - 1), (x - 1, y + 1), (x + 1, y - 1))
        .filter { case (nx, ny) => nx >= 0 && ny >= 0 && nx < w && ny < h }
      (x, y) -> Vertex(value, x, y, neighbors)
    }
  }.toMap

  def dfs(vertex: Vertex, visited: Seq[Vertex] = Seq()): Seq[Vertex] = {
    if (visited.contains(vertex)) visited
    else vertex.neighbors.map(n => board(n)).filterNot(n => visited.contains(n)).filter(_.char == vertex.char)
      .foldLeft(vertex +: visited) { (acc, next) => dfs(next, acc) }
  }

  val whiteWins: Boolean =
    board.values.filter { v => v.y == 0 && v.char == 'O' }
      .map(start => dfs(start)).exists(_.exists(v => v.y == h - 1))
  lazy val blackWins: Boolean =
    board.values.filter { v => v.x == 0 && v.char == 'X' }
      .map(start => dfs(start)).exists(_.exists(v => v.x == w - 1))
  val winner: Option[Color] = if (whiteWins) Some(Color.White) else if (blackWins) Some(Color.Black) else None
}
