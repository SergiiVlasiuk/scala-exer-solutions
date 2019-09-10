case class Deque2[T]() {
  var first:Option[Element[T]] = None
  def last = first.get.prev

  def push(v:T) = insert(v)
  def unshift(v:T) = first = insert(v)

  def pop:Option[T] = {
    var result = last.get.value
    last.get.prev.get.next = first
    first.get.prev = last.get.prev
    Some(result)
  }
  def shift:Option[T] = {
    var result = first.get.value
    first.get.next.get.prev = last
    last.get.next = first.get.next
    first = first.get.next
    Some(result)
  }

  private def insert(v:T) = {
    first match {
      case Some(f) => {
        val newElement = Some(Element[T](v, last, first))
        last.get.next = newElement
        first.get.prev = newElement
        newElement
      }
      case _ => {
        val newElement = Some(Element[T](v))
        newElement.get.prev = newElement
        newElement.get.next = newElement
        first = newElement
        newElement
      }
    }
  }

}

case class Element[T](value:T, var prev:Option[Element[T]]=None, var next:Option[Element[T]]=None)