class SimpleLinkedList5[T](var element: Option[T] = None,
                           var nextList: Option[SimpleLinkedList5[T]] = None) {
  def isEmpty: Boolean = element == None

  def value: T = element.get

  def add(item: T): SimpleLinkedList5[T] = {
    if (isEmpty) {
      element = Some(item)
      nextList = Some(new SimpleLinkedList5())
    } else {
      nextList match {
        case None =>
          nextList = Some(
            new SimpleLinkedList5[T](Some(item), Some(new SimpleLinkedList5()))
          )
        case Some(next) => next.add(item)
      }
    }
    this
  }

  def next: SimpleLinkedList5[T] = this.nextList.get

  def reverse: SimpleLinkedList5[T] = nextList match {
    case None => new SimpleLinkedList5(element)
    case Some(next) => next.reverse.add(value)
  }

  def toSeq: Seq[T] = element match {
    case Some(item) => item +: next.toSeq
    case None => Seq.empty[T]
  }
}

object SimpleLinkedList5 {
  def apply[T](items: T*): SimpleLinkedList5[T] = fromSeq(items.toSeq)

  def fromSeq[T](seq: Seq[T]): SimpleLinkedList5[T] = {
    seq.foldLeft(new SimpleLinkedList5[T]()) {
      (list, item) => list.add(item)
    }
  }
}
