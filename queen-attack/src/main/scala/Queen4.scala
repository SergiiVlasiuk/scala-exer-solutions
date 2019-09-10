case class Queen4(row: Int, col: Int)

object Queen4 {
  private val dim: Int = 8

  def isValid(pos: Int): Boolean = pos >= 0 && pos < dim

  def create(row: Int, col: Int): Option[Queen4] =
    if (isValid(row) && isValid(col)) Some(Queen4(row, col))
    else None
}

object Queen4Attack {
  private def sharedRowOrCol(q1: Queen4, q2: Queen4): Boolean =
    q1.row == q2.row || q1.col == q2.col

  private val sharedDiagonal = (q1: Queen4, q2: Queen4) =>
    math.abs(q2.row - q1.row) == math.abs(q2.col - q1.col)

  def canAttack(q1: Queen4, q2: Queen4): Boolean =
    sharedRowOrCol(q1, q2) || sharedDiagonal(q1, q2)
}
