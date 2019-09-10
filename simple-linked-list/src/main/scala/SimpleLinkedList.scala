trait SimpleLinkedList[T] {
  def isEmpty: Boolean

  def value: T

  def add(item: T): SimpleLinkedList[T]

  def next: SimpleLinkedList[T]

  def reverse: SimpleLinkedList[T]

  def toSeq: Seq[T]
}

class LinkedList[T](seq: Seq[T]) extends SimpleLinkedList[T] {
  private val list = seq.toList

  def isEmpty = list.isEmpty

  def value = list.head

  def add(item: T): SimpleLinkedList[T] = new LinkedList[T](list :+ item)

  def next = new LinkedList(list.tail)

  def reverse = new LinkedList(list.reverse)

  def toSeq = list
}

object SimpleLinkedList {
  def apply[T](ts: T*): SimpleLinkedList[T] = fromSeq[T](ts.toSeq)

  def fromSeq[T](seq: Seq[T]): SimpleLinkedList[T] = new LinkedList[T](seq)
}