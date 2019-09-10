case class Matrix3(matrix: String) {
  def row(row: Int): Vector[Int] = matrix.split("\n")(row)
    .split(" ").map(_.toInt).toVector

  def column(column: Int): Vector[Int] =
    matrix.split("\n").map(i => {
      i.split(" ")(column).toInt
    }).toVector
}
