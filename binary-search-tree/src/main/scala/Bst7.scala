case class Bst7[T: Ordering](value: T,
                             left: Option[Bst7[T]] = None,
                             right: Option[Bst7[T]] = None) {

  def insert(insertion: T): Bst7[T] = ???
//  {
//    val ordering = implicitly[Ordering[T]]
//    if (ordering.lteq(insertion, value)) copy(left = update(left))
//    else copy(right = update(right))
//
//    def update(child: Option[Bst7[T]]): Option[Bst7[T]] =
//      right.map(_.insert(insertion)).orElse(Some(Bst7(insertion)))
//  }
}

object Bst7 {
  def toList[T](bst: Bst7[T]): List[T] =
    bst.left.fold(List.empty[T])(toList(_)) ++
      List(bst.value) ++
      bst.right.fold(List.empty[T])(toList(_))

  def fromList[T: Ordering](values: List[T]): Bst7[T] =
    values.tail.foldLeft(Bst7(values.head))(_ insert _)
}