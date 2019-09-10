import scala.annotation.tailrec

object SpiralMatrix {
  def spiralMatrix(size: Int): List[List[Int]] = {
    @tailrec
    def spiralMatrixValue(size: Int, startValue: Int, row: Int, col: Int): Int = {
      (row, col) match {
        case (0, _) => startValue + col
        case _ if col == size - 1 => startValue + size + row - 1
        case _ if row == size - 1 => startValue + size * 3 - 3 - col
        case (_, 0) => startValue + size * 4 - 4 - row
        case _ => spiralMatrixValue(size - 2, startValue + size * 4 - 4, row - 1, col - 1)
      }
    }
    //    List.range(0, size).map(row =>
    //      List.range(0, size).map(col => spiralMatrixValue(size, 1, row, col)))
    List.tabulate(size, size)((x: Int, y: Int) => spiralMatrixValue(size, 1, x, y))
  }
}


/*
object SpiralMatrix {
  def spiralMatrix(size: Int): List[List[Int]] = {
    @tailrec
    def spiralMatrixValue(size: Int, startValue: Int, row: Int, col: Int): Int = {
      (row, col) match {
        case (0, _) =>
          println(s"case (0, _) => startValue + col = $startValue + $col = " + (startValue + col))
          startValue + col
        case _ if col == size - 1 =>
          println(s"case _ if col == size - 1 => startValue + size + row - 1 = $startValue + $size + $row - 1 = " + (startValue + size + row - 1))
          startValue + size + row - 1
        case _ if row == size - 1 =>
          println(s"case _ if row == size - 1 => startValue + size * 3 - 3 - col = $startValue + $size * 3 - 3 - $col = " + (startValue + size * 3 - 3 - col))
          startValue + size * 3 - 3 - col
        case (_, 0) =>
          println(s"case (_, 0) => startValue + size * 4 - 4 - row = $startValue + $size * 4 - 4 - $row = " + (startValue + size * 4 - 4 - row))
          startValue + size * 4 - 4 - row
        case _ =>
          println(s"case _ => different function call: spiralMatrixValue($size - 2, $startValue + $size * 4 - 4, $row - 1, $col - 1)")
          spiralMatrixValue(size - 2, startValue + size * 4 - 4, row - 1, col - 1)
      }
    }
//    List.tabulate(size, size)((x: Int, y: Int) => spiralMatrixValue(size, 1, x, y))
        List.range(0, size).map(row =>
          List.range(0, size).map(col => {
            val value = spiralMatrixValue(size, 1, row, col)
//            println(s"size: $size, row: $row, col: $col, value: " + value)
            value
          }))
//        List.range(0, size).map(row =>
//          List.range(0, size).map(col => spiralMatrixValue(size, 1, row, col)))
  }
}
*/
