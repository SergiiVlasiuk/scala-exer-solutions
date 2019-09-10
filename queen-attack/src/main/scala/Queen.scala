import scala.util.Try

case class Queen(row: Int, col: Int) {
  require(0 <= row && row < 8)
  require(0 <= col && col < 8)
}

object Queen {
  def create(row: Int, col: Int): Option[Queen] = Try[Queen](Queen(row, col)).toOption
}

object QueenAttack {
  def canAttack(q1: Queen, q2: Queen): Boolean = q1 match {
    case Queen(row, col) if row == q2.row => true
    case Queen(row, col) if col == q2.col => true
    case Queen(row, col) if math.abs(row - q2.row) == math.abs(col - q2.col) => true
    case _ => false
  }
}
