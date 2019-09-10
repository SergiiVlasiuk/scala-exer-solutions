case class Matrix4(matrix: String) {
  private lazy val rows = matrix.linesIterator.map(_.split(" ").map(_.toInt)).toList
  private lazy val columns = rows.transpose

  def row(r: Int): Array[Int] = rows(r)

  def column(c: Int): List[Int] = columns(c)
}
