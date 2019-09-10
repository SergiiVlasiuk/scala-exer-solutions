trait SimpleLinkedList3[T] {
  def isEmpty: Boolean

  def value: T

  def add(item: T): SimpleLinkedList3[T]

  def next: SimpleLinkedList3[T]

  def reverse: SimpleLinkedList3[T]

  def toSeq: Seq[T]
}

case class Element[T](item: T, next: Option[Element[T]] = None)

class SimpleList[T](head: Option[Element[T]]) extends SimpleLinkedList3[T] {
  def isEmpty: Boolean = head.isEmpty

  def value: T = head.get.item

  def add(item: T): SimpleLinkedList3[T] = {
    def append(next: Option[Element[T]]): Element[T] = next match {
      case None => Element(item)
      case Some(cur) => Element(cur.item, Some(append(cur.next)))
    }

    SimpleLinkedList3(Some(append(head)))
  }

  def next: SimpleLinkedList3[T] = SimpleLinkedList3(head.get.next)

  def reverse: SimpleLinkedList3[T] = {
    def rev(acc: Option[Element[T]], next: Option[Element[T]]): Option[Element[T]] = next match {
      case None => acc
      case Some(cur) => rev(Some(Element(cur.item, acc)), cur.next)
    }

    SimpleLinkedList3(rev(None, head))
  }

  def toSeq: Seq[T] = {
    def seq(next: Option[Element[T]]): List[T] = next match {
      case None => Nil
      case Some(cur) => cur.item :: seq(cur.next)
    }

    seq(head)
  }
}

object SimpleLinkedList3 {
  def apply[T](): SimpleLinkedList3[T] = new SimpleList(None)

  def apply[T](elem: Option[Element[T]]): SimpleLinkedList3[T] = new SimpleList(elem)

  def apply[T](items: T*): SimpleLinkedList3[T] = items.foldLeft(SimpleLinkedList3[T]())(_.add(_))

  def fromSeq[T](items: Seq[T]) = apply(items: _*)
}