object Minesweeper4 {
  type Board = List[String]

  def annotate(board: Board): Board = {
    def mines(row: Int, col: Int) = (for (
      y <- row - 1 to row + 1 if y >= 0 && y < board.length;
      x <- col - 1 to col + 1 if x >= 0 && x < board(y).length && board(y)(x) == '*'
    ) yield 1).sum

    def count(row: Int, col: Int): String = mines(row, col) match {
      case 0 => " "
      case n => n.toString
    }

    board.zipWithIndex.map {
      case (columns, row) => columns.zipWithIndex.map {
        case (field, col) => if (field == ' ') count(row, col) else field
      }.mkString
    }
  }
}
