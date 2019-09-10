case class Bst6[T: Ordering](value: T, left: Option[Bst6[T]], right: Option[Bst6[T]]) {
  def insert(newValue: T): Bst6[T] =
    if (Ordering[T].lteq(newValue, value)) new Bst6(value, insert(newValue, left), right)
    else new Bst6(value, left, insert(newValue, right))

  private def insert(newValue: T, tree: Option[Bst6[T]]): Option[Bst6[T]] = tree match {
    case Some(branch) => Some(branch.insert(newValue))
    case None => Some(Bst6(newValue))
  }
}

object Bst6 {
  def apply[T: Ordering](value: T): Bst6[T] = new Bst6(value, None, None)

  def fromList[T: Ordering](values: List[T]) = values match {
    case x :: xs => xs.foldLeft(Bst6(x))((tree, value) => tree.insert(value))
    case Nil => throw new IllegalArgumentException("Cannot create tree from empty list")
  }

  def toList[T: Ordering](tree: Bst6[T]): List[T] = toList(Some(tree))

  private def toList[T: Ordering](tree: Option[Bst6[T]]): List[T] = tree match {
    case Some(x) => toList(x.left) ++ List(x.value) ++ toList(x.right)
    case None => Nil
  }
}
