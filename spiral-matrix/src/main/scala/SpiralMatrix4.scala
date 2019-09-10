object SpiralMatrix4 {
  def spiralMatrix(size: Int): List[List[Int]] = {
    @scala.annotation.tailrec
    def spiralMatrixValue(size: Int, startingValue: Int, row: Int, col: Int): Int = {
      (row, col) match {
        case (0, _) => startingValue + col
        case _ if (col == size - 1) => startingValue + size + row - 1
        case _ if (row == size - 1) => startingValue + (size - 1) * 3 - col
        case _ if (col == 0) => startingValue + (size - 1) * 4 - row
        case _ => spiralMatrixValue(size - 2, startingValue + (size - 1) * 4, row - 1, col - 1)
      }
    }

    List.tabulate(size, size)((x: Int, y: Int) => spiralMatrixValue(size, 1, x, y))
  }
}
