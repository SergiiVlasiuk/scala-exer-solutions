object PascalsTriangle4 {
  private val FirstRow: Vector[Int] = Vector(1)

  def rows(numRows: Int) = Vector.iterate(FirstRow, numRows)(nextRow)

  def nextRow(row: Seq[Int]) = (0 +: row :+ 0).sliding(2) map (_.sum) toVector
}
