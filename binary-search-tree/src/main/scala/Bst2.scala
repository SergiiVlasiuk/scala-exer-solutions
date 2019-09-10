case class Bst2[T: Ordering](value: T, left: Option[Bst2[T]] = None, right: Option[Bst2[T]] = None) {

  def insert(item: T): Bst2[T] = {
    import scala.math.Ordering.Implicits._
    if (item <= value) {
      left match {
        case None => copy(left = Some(Bst2(item)))
        case Some(nd) => copy(left = Some(nd.insert(item)))
      }
    } else {
      right match {
        case None => copy(right = Some(Bst2(item)))
        case Some(nd) => copy(right = Some(nd.insert(item)))
      }
    }
  }
}

object Bst2 {
  def appy[T: Ordering](item: T) = new Bst2(item)

  def fromList[T: Ordering](list: List[T]): Bst2[T] = {
    require(list != Nil)
    list.tail.foldLeft(Bst2(list.head))((acc, item) => acc.insert(item))
  }

  def toList[T: Ordering](bst: Bst2[T]): List[T] = {
    val buffer = collection.mutable.ListBuffer[T]()

    def loop(node: Bst2[T]): Unit = {
      if (node.left.isDefined) loop(node.left.get)
      buffer += node.value
      if (node.right.isDefined) loop(node.right.get)
    }

    loop(bst)
    buffer.toList
  }
}