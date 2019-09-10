case class Matrix[T](matrix: Seq[Array[T]]) {
  val row: Int => Array[T] = matrix
  val column: Int => Seq[T] = matrix.transpose
}

object Matrix {
  def apply(matrix: String): Matrix[Int] =
    Matrix(matrix.linesIterator.map(_.split(' ').map(_.toInt)).toVector)
}
