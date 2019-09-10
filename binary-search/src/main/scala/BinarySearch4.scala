object BinarySearch4 {
  def find(sl: List[Int], e: Int): Option[Int] = {
    @annotation.tailrec
    def loop(l: List[(Int, Int)], e: Int): Option[Int] = l.splitAt(l.length / 2) match {
      case (Nil, (i, index) :: Nil) => if (i == e) Some(index) else None
      case (ll, (i, index) :: t) => if (e == i) Some(index)
      else if (e < i) loop(ll, e)
      else loop(t, e)
      case _ => None
    }

    if (sl.isEmpty) None else loop(sl.zipWithIndex, e)
  }
}
