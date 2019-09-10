import scala.annotation.tailrec

object Zipper2 {
  // Get a zipper focussed on the root node.
  def fromTree[A](bt: BinTree2[A]): Zipper2[A] = Zipper2(bt, List())

  // Get the complete tree from a zipper.
  @tailrec
  def toTree[A](zipper: Zipper2[A]): BinTree2[A] = up(zipper) match {
    case Some(z) => toTree(z)
    case None => zipper.focus
  }

  // Get the value of the focus node.
  def value[A](zipper: Zipper2[A]): A = zipper.focus.value

  // Get the left child of the focus node, if any.
  def left[A](zipper: Zipper2[A]): Option[Zipper2[A]] =
    zipper.focus.left.map(Zipper2(_, Breadcrumb(Direction.Left, zipper.focus) :: zipper.history))

  // Get the right child of the focus node, if any.
  def right[A](zipper: Zipper2[A]): Option[Zipper2[A]] =
    zipper.focus.right.map(Zipper2(_, Breadcrumb(Direction.Right, zipper.focus) :: zipper.history))

  // Get the parent of the focus node, if any.
  def up[A](zipper: Zipper2[A]): Option[Zipper2[A]] = zipper.history match {
    case Breadcrumb(Direction.Left, parent) :: hs => Some(Zipper2(parent.copy(left = Some(zipper.focus)), hs))
    case Breadcrumb(Direction.Right, parent) :: hs => Some(Zipper2(parent.copy(right = Some(zipper.focus)), hs))
    case _ => None
  }

  // Set the value of the focus node.
  def setValue[A](v: A, zipper: Zipper2[A]): Zipper2[A] = zipper.copy(focus = zipper.focus.copy(value = v))

  // Replace a left child tree.
  def setLeft[A](l: Option[BinTree2[A]], zipper: Zipper2[A]): Zipper2[A] = zipper.copy(focus = zipper.focus.copy(left = l))

  // Replace a right child tree.
  def setRight[A](r: Option[BinTree2[A]], zipper: Zipper2[A]): Zipper2[A] = zipper.copy(focus = zipper.focus.copy(right = r))
}

object Direction extends Enumeration {
  type Direction = Value
  val Left, Right = Value
}

// Breadcrumb indicates tree's parent and its position relative to it.
case class Breadcrumb[A](direction: Direction.Direction, tree: BinTree2[A])

case class Zipper2[A](focus: BinTree2[A], history: List[Breadcrumb[A]])

// A binary tree.
case class BinTree2[A](value: A, left: Option[BinTree2[A]], right: Option[BinTree2[A]])
