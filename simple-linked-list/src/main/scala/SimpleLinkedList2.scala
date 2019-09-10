trait SimpleLinkedList2[T] {
  def isEmpty: Boolean

  def value: T

  def add(item: T): SimpleLinkedList2[T]

  def next: SimpleLinkedList2[T]

  def reverse: SimpleLinkedList2[T]

  def toSeq: Seq[T]
}

case object Empty2 extends SimpleLinkedList2[Any] {
  override def isEmpty: Boolean = true

  override def value: Any = throw new Exception

  override def add(item: Any): SimpleLinkedList2[Any] = NonEmpty2(item, Empty2.asInstanceOf[SimpleLinkedList2[Any]])

  override def next: SimpleLinkedList2[Any] = throw new Exception

  override def reverse: SimpleLinkedList2[Any] = Empty2

  override def toSeq: Seq[Any] = Seq.empty
}

case class NonEmpty2[T](_value: T, var _next: SimpleLinkedList2[T]) extends SimpleLinkedList2[T] {
  override def isEmpty: Boolean = false

  override def value: T = _value

  override def add(item: T): SimpleLinkedList2[T] = {
    _next = _next.add(item)
    this
  }

  override def next: SimpleLinkedList2[T] = _next

  override def reverse: SimpleLinkedList2[T] = {
    def loop(previous: SimpleLinkedList2[T], current: SimpleLinkedList2[T]): SimpleLinkedList2[T] = {
      current match {
        case NonEmpty2(v: T, n: SimpleLinkedList2[T]) => loop(NonEmpty2(current.value, previous), n)
        case _ => previous
      }
    }

    loop(Empty2.asInstanceOf[SimpleLinkedList2[T]], this)
  }

  override def toSeq: Seq[T] = {
    def loop(acc: List[T], current: SimpleLinkedList2[T]): List[T] = {
      current match {
        case NonEmpty2(v: T, n: SimpleLinkedList2[T]) => loop(v :: acc, n)
        case _ => acc.reverse
      }
    }

    loop(List(value), this._next)
  }
}

object SimpleLinkedList2 {
  def apply[T](): SimpleLinkedList2[T] = Empty2.asInstanceOf[SimpleLinkedList2[T]]

  def apply[T](values: T*): SimpleLinkedList2[T] = fromSeq(values)

  def fromSeq[T](values: Seq[T]): SimpleLinkedList2[T] = values.foldLeft[SimpleLinkedList2[T]](Empty2.asInstanceOf[SimpleLinkedList2[T]]) { case (acc, value) => acc.add(value) }
}
