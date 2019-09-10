case class Node[+A](value: A, left: Option[Node[A]], right: Option[Node[A]]) {
  def insert[B >: A <% Ordered[B]](v: B): Node[B] =
    v match {
      case v if v <= value => Node(value, insertAtNode(v, left), right)
      case v if v > value => Node(value, left, insertAtNode(v, right))
    }

  private
  def insertAtNode[B >: A <% Ordered[B]](v: B, node: Option[Node[B]]): Option[Node[B]] =
    node match {
      case Some(x) => Option(x.insert(v))
      case _ => Option(Node(v, None, None))
    }
}

object Bst4 {
  def apply[A](value: A): Node[A] = Node(value, None, None)

  def toList[A](node: Node[A]): List[A] = node match {
    case (Node(value, Some(left), Some(right))) => toList(left) ::: value :: toList(right)
    case (Node(value, Some(left), None)) => (value :: toList(left)).reverse
    case (Node(value, None, Some(right))) => value :: toList(right)
    case (Node(value, None, None)) => List(value)
  }

  def fromList[A <% Ordered[A]](list: List[A]): Node[A] = list match {
    case x :: xs => xs.foldLeft(Node(x, None, None)){(result, input) => result.insert(input)}
    case x :: Nil => Node(x, None, None)
    case Nil => throw new IllegalArgumentException("Node must not be empty!")
  }
}
