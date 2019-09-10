case class Matrix2(matrix: String) {
  private val RowSeparator = "\n"
  private val ColSeparator = " "
  private lazy val rows: Vector[Vector[Int]] = matrix.split(RowSeparator).toVector.map(_.split(ColSeparator).map(_.toInt).toVector)
  private lazy val cols: Vector[Vector[Int]] = rows.transpose

  def column(i: Int): Vector[Int] = cols(i)

  def row(i: Int): Vector[Int] = rows(i)
}
