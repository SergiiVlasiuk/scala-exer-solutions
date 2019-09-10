import scala.annotation.tailrec

object BinarySearch3 {
  def find(haystack: List[Int], needle: Int): Option[Int] = {
    @tailrec
    def loop(values: List[Int], index: Int): Option[Int] = values match {
      case Nil => None
      case _ =>
        val (left, right) = values.splitAt(values.length / 2)
        if (right.head == needle) Some(index + left.length)
        else if (right.head > needle) loop(left, index)
        else loop(right.tail, index + left.length + 1)
    }

    loop(haystack, 0)
  }
}
