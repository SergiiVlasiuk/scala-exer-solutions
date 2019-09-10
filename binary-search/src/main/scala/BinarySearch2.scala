import scala.annotation.tailrec

object BinarySearch2 {
  def find(ints: List[Int], i: Int): Option[Int] = {
    @tailrec
    def inner(l: Int, r: Int): Option[Int] = {
      val m = (l + r) / 2
      if (l > r) None
      else if (ints(m) < i) inner(m + 1, r)
      else if (ints(m) > i) inner(l, m - 1)
      else Some(m)
    }

    inner(0, ints.size - 1)
  }
}
