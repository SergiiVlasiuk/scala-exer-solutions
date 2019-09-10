case class Deque5[T]() {
  var head: Option[Node[T]] = None
  var tail: Option[Node[T]] = None

  def push(value: T) = tail match {
    case None => tail = Some(new Node(value, None, None)); head = tail
    case Some(node) => tail = node.putNext(new Node(value, tail, None))
  }

  def pop() = tail match {
    case None => None
    case Some(node) => val nValue = node.getValue; tail = node.RemoveTail(); Some(nValue);
  }

  def shift() = head match {
    case None => None
    case Some(node) => val nValue = node.getValue; head = node.RemoveHead(); Some(nValue);
  }

  def unshift(value: T) = head match {
    case None => head = Some(new Node(value, None, None)); tail = head
    case Some(node) => head = node.putPrev(new Node(value, None, head))
  }

  class Node[T](value: T, var prev: Option[Node[T]] = None, var next: Option[Node[T]] = None) {
    def getValue() = value

    def putNext(that: Node[T]) = {
      next = Some(that); next
    }

    def putPrev(that: Node[T]) = {
      prev = Some(that); prev
    }

    def RemoveTail() = {
      prev.map(_.next = None); prev
    }

    def RemoveHead() = {
      next.map(_.prev = None); next
    }
  }
}
