object Zipper3 {
  // Get a zipper focused on the root node.
  def fromTree[A](bt: BinTree3[A]): Zipper3[A] = Top(bt)

  // Get the complete tree from a zipper.
  def toTree[A](zipper: Zipper3[A]): BinTree3[A] = zipper.parent.map(p => toTree(p)).getOrElse(zipper.tree)

  // Get the value of the focus node.
  def value[A](zipper: Zipper3[A]): A = zipper.tree.value

  // Get the left child of the focus node, if any.
  def left[A](zipper: Zipper3[A]): Option[Zipper3[A]] = zipper.tree.left.map(v => Left(Some(zipper), v))

  // Get the right child of the focus node, if any.
  def right[A](zipper: Zipper3[A]): Option[Zipper3[A]] = zipper.tree.right.map(v => Right(Some(zipper), v))

  // Get the parent of the focus node, if any.
  def up[A](zipper: Zipper3[A]): Option[Zipper3[A]] = zipper.parent

  // Set the value of the focus node.
  def setValue[A](v: A, zipper: Zipper3[A]): Zipper3[A] = zipper.update(zipper.tree.copy(value = v))

  // Replace a left child tree.
  def setLeft[A](l: Option[BinTree3[A]], zipper: Zipper3[A]): Zipper3[A] = zipper.update(zipper.tree.copy(left = l))

  // Replace a right child tree.
  def setRight[A](r: Option[BinTree3[A]], zipper: Zipper3[A]): Zipper3[A] = zipper.update(zipper.tree.copy(right = r))
}

// A binary tree.
case class BinTree3[A](value: A, left: Option[BinTree3[A]], right: Option[BinTree3[A]])

// A zipper for a binary tree.
sealed trait Zipper3[A] {
  val tree: BinTree3[A]
  val parent: Option[Zipper3[A]]

  def update(newTree: BinTree3[A]): Zipper3[A]
}

case class Top[A](tree: BinTree3[A]) extends Zipper3[A] {
  override val parent: Option[Zipper3[A]] = None

  override def update(newTree: BinTree3[A]): Zipper3[A] = Top(newTree)
}

case class Right[A](parent: Option[Zipper3[A]], tree: BinTree3[A]) extends Zipper3[A] {
  override def update(newTree: BinTree3[A]): Zipper3[A] = Right(parent.map(p => p.update(p.tree.copy(right = Some(newTree)))), newTree)
}

case class Left[A](parent: Option[Zipper3[A]], tree: BinTree3[A]) extends Zipper3[A] {
  override def update(newTree: BinTree3[A]): Zipper3[A] = Left(parent.map(p => p.update(p.tree.copy(left = Some(newTree)))), newTree)
}
