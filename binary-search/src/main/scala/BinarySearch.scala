import scala.annotation.tailrec

object BinarySearch {
  def find(list: List[Int], target: Int): Option[Int] = {
    @tailrec
    def binaryFind(left: Int, mid: Int, right: Int): Option[Int] = list match {
      case Nil => None
      case x => (left, mid, right) match {
        case (_, m, _) if x(m) == target => Some(m)
        case (l, _, r) if l >= r => None
        case (l, m, r) if x(m) < target => binaryFind(m + 1, (m + 1 + r) / 2, r)
        case (l, m, r) if x(m) > target => binaryFind(l, (r - m - 1) / 2, m - 1)
      }
    }

    binaryFind(0, list.length / 2, list.length - 1)
  }
}
