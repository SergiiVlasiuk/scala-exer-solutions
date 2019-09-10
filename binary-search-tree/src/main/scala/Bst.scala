object Bst {
  def fromList(l: List[Int]): Bst = l match {
    case Nil => throw new IllegalArgumentException("At least 1 item in the list is required")
    case x :: xs => xs.foldLeft(Bst(x))((agg, x) => agg.insert(x))
  }

  def toList(bst: Bst): List[Int] = bst match {
    case Bst(v, Some(left), Some(right)) => toList(left) ++ (v :: toList(right))
    case Bst(v, None, Some(right)) => v :: toList(right)
    case Bst(v, Some(left), None) => toList(left) ++ (v :: Nil)
    case Bst(v, None, None) => v :: Nil
  }
}

case class Bst(value: Int, left: Option[Bst] = None, right: Option[Bst] = None) {
  def insert(item: Int): Bst = if (item <= value) { // to left
    val newLeft = if (left == None) Bst(item) else left.get.insert(item)
    Bst(value, Some(newLeft), right)
  } else { //to right
    val newRight = if (right == None) Bst(item) else right.get.insert(item)
    Bst(value, left, Some(newRight))
  }
}
