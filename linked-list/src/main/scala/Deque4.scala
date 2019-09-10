object Deque4 {
  object Node {
    def apply[A](value:A, next: Option[Node[A]], prev: Option[Node[A]]) =
      new Node(value, next, prev)
  }

  class Node[A](val value: A,
                private var _next: Option[Node[A]],
                private var _prev: Option[Node[A]]) {
    def next = _next
    def next_= (next: Option[Node[A]]) = _next = next

    def prev = _prev
    def prev_= (prev: Option[Node[A]]) = _prev = prev
  }

  def apply[T]() = new Deque4[T]()
}

class Deque4[A] {
  import Deque4._

  private var _head: Option[Node[A]] = None
  private var _tail: Option[Node[A]] = None

  def unshift(a: A) = {
    _head = Option(Node(a, _head, None))
    _tail.foreach(_.prev = _head)
    _tail = _tail.orElse(_head)
  }

  def shift: Option[A] = {
    val node = _head
    _tail = if(_tail == _head) None else _tail
    _head = node.flatMap(n=> n.next)
    node.map(_.value)
  }

  def push(a: A) = {
    _tail = Option(Node(a, None, _tail))
    _head.foreach(_.next = _tail)
    _head = _head.orElse(_tail)
  }

  def pop: Option[A] = {
    val node = _tail
    _head = if(_tail == _head) None else _head
    _tail = node.flatMap(n=> n.prev)
    node.map(_.value)
  }
}