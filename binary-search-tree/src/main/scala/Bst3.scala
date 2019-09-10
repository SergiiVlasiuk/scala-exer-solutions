case class Bst3[T](value: T, left: Option[Bst3[T]] = None, right: Option[Bst3[T]] = None)

object Bst3 {
  def fromList[T: Ordering](from: Seq[T]): Bst3[T] =
    from.tail.foldLeft(Bst3(from.head)) { case (acc, e) => acc.insert(e) }

  def toList[T](e: Bst3[T]): Seq[T] = (e.left, e.right) match {
    case (None, None) => Seq(e.value)
    case (Some(l), Some(r)) => toList(l) ++ Seq(e.value) ++ toList(r)
    case (Some(l), _) => toList(l) ++ Seq(e.value)
    case (_, Some(r)) => Seq(e.value) ++ toList(r)
  }

  implicit class RichBst3[T: Ordering](bst: Bst3[T]) {
    def insert(e: T): Bst3[T] = {
      val f = implicitly[Ordering[T]]
      val toRight = f.compare(bst.value, e) < 0
      (bst.left, bst.right, toRight) match {
        case (None, _, false) => bst.copy(left = Option(Bst3(e)))
        case (Some(l), _, false) => bst.copy(left = Option(l.insert(e)))
        case (_, None, true) => bst.copy(right = Option(Bst3(e)))
        case (_, Some(r), true) => bst.copy(right = Option(r.insert(e)))
      }
    }
  }

}
