case class Matrix(list: List[List[Int]]) {
  val saddlePoints: Set[(Int, Int)] = (for {
    row <- list.indices
    col <- list.head.indices
    transposed = list.transpose
    if list(row).max == list(row)(col) && transposed(col).min == list(row)(col)
  } yield (row, col)).toSet
}
