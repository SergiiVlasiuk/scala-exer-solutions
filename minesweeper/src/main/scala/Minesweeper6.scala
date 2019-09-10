object Minesweeper6 {
  private val offsets = Seq(
    (-1, -1), (-1, 0), (-1, 1),
    (0, -1), (0, 1),
    (1, -1), (1, 0), (1, 1)
  )

  def annotate(input: Seq[String]): Seq[String] = {
    val board = input.map(_.toArray).toArray
    input.zipWithIndex
      .map { case (row, y) =>
        row.zipWithIndex.map { case (char, x) =>
          if (char == '*') char
          else offsets.map { case (dy, dx) => (y + dy, x + dx) }
            .filter { case (dy, dx) => board.indices.contains(dy) && board(0).indices.contains(dx) }
            .count { case (dy, dx) => board(dy)(dx) == '*' }.toString
            .replace('0', ' ')
        }.mkString
      }
  }
}
