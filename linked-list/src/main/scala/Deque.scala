case class Deque[T]() {
  private var head: Option[Node] = None
  private var last: Option[Node] = None

  case class Node(value: T, var prev: Option[Node], var next: Option[Node])

  def push(value: T) {
    val node = Node(value, last, None)
    last.foreach(_.next = Some(node))
    last = Some(node)
    if (head.isEmpty) head = last
  }

  def unshift(value: T) {
    val node = Node(value, None, head)
    head.foreach(_.prev = Some(node))
    head = Some(node)
    if (last.isEmpty) last = head
  }

  def pop = {
    val value = last.map(_.value)
    last = last.flatMap(_.prev)
    if (last.isEmpty) head = None
    value
  }

  def shift = {
    val value = head.map(_.value)
    head = head.flatMap(_.next)
    if (head.isEmpty) last = None
    value
  }
}
