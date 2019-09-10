trait SimpleLinkedList4[T] {
  def isEmpty: Boolean

  def value: T

  def add(item: T): SimpleLinkedList4[T]

  def next: SimpleLinkedList4[T]

  def reverse: SimpleLinkedList4[T]

  def toSeq: Seq[T]
}

class LinkedList4[T](seq: Seq[T]) extends SimpleLinkedList4[T] {
  val queue = collection.immutable.Queue[T](seq: _*)

  def add(elem: T) = new LinkedList4(queue.enqueue(elem))

  def isEmpty = queue.isEmpty

  def value = queue.head

  def next = new LinkedList4(queue.tail)

  def reverse = new LinkedList4(queue.reverse)

  def toSeq = queue.toSeq
}

object SimpleLinkedList4 {
  def apply[T](): SimpleLinkedList4[T] = apply(Nil: _*)

  def apply[T](seq: T*): SimpleLinkedList4[T] = new LinkedList4[T](seq)

  def fromSeq[T](seq: Seq[T]) = new LinkedList4(seq)
}