import scala.util.Try

case class Queen2(row: Int, col: Int) {
  require(0 <= row && row < 8)
  require(0 <= col && col < 8)
}

object Queen2 {
  def create(row: Int, col: Int) = Try[Queen2](Queen2(row, col)).toOption
}

object Queen2Attack {

  def canAttack(q1: Queen2, q2: Queen2): Boolean =
    sameRowOrCol(q1, q2) || sameDiagonal(q1, q2)

  private def sameRowOrCol(q1: Queen2, q2: Queen2): Boolean =
    q1.row == q2.row || q1.col == q2.col

  private def sameDiagonal(q1: Queen2, q2: Queen2): Boolean =
    math.abs(q1.row - q2.row) == math.abs(q1.col - q2.col)
}
