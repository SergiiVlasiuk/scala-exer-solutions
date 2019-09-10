object PascalsTriangle3 {
  private def createPyramide(actualRow: List[Long], nextRow: List[Long]): Stream[List[Long]] = {
    val newRow = nextRow.head :: nextRow.zip(nextRow.tail).map(x => x._1 + x._2) ::: nextRow.last :: Nil
    actualRow #:: createPyramide(nextRow, newRow)
  }

  val pyramid = createPyramide(List(1), List(1, 1))

  def rows(lineNumber: Int): List[List[Long]] = pyramid.take(lineNumber).toList
}
