case class Queen3(row: Int, col: Int)

object Queen3 {
  def create(row: Int, col: Int) = (row, col) match {
    case (row, col) if row >= 0 && col >= 0 && row < 8 && col < 8 => Some(Queen3(row, col))
    case _ => None
  }
}

object Queen3Attack {
  def canAttack(q1: Queen3, q2: Queen3) = q1 match {
    case Queen3(x, y) if x == q2.row => true
    case Queen3(x, y) if y == q2.col => true
    case Queen3(x, y) if x - q2.row == y - q2.col => true
    case Queen3(x, y) if x - q2.row == q2.col - y => true
    case _ => false
  }
}
