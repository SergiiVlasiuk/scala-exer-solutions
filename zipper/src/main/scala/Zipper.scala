object Zipper {
  // Get a zipper focussed on the root node.
  def fromTree[A](bt: BinTree[A]): Zipper[A] = Zipper[A](List(), bt)

  // Get the complete tree from a zipper.
  def toTree[A](zipper: Zipper[A]): BinTree[A] = {
    zipper.context.foldLeft(zipper.tree) { case (bt, context) =>
      context.dir match {
        case true => BinTree(context.point, Some(bt), context.container)
        case false => BinTree(context.point, context.container, Some(bt))
      }
    }
  }

  // Get the value of the focus node.
  def value[A](zipper: Zipper[A]): A = zipper.tree.value

  // Get the left child of the focus node, if any.
  def left[A](zipper: Zipper[A]): Option[Zipper[A]] = {
    import zipper.tree
    tree.left.map { bt =>
      Zipper(Context(tree.value, true, tree.right) :: zipper.context, bt)
    }
  }

  // Get the right child of the focus node, if any.
  def right[A](zipper: Zipper[A]): Option[Zipper[A]] = {
    import zipper.tree
    tree.right.map { bt =>
      Zipper(Context(tree.value, false, tree.left) :: zipper.context, bt)
    }
  }

  // Get the parent of the focus node, if any.
  def up[A](zipper: Zipper[A]): Option[Zipper[A]] = {
    zipper.context.headOption.map { ctx =>
      Zipper(zipper.context.tail,
        ctx.dir match {
          case true => BinTree(ctx.point, Some(zipper.tree), ctx.container)
          case false => BinTree(ctx.point, ctx.container, Some(zipper.tree))
        })
    }
  }

  // Set the value of the focus node.
  def setValue[A](v: A, zipper: Zipper[A]): Zipper[A] = {
    import zipper.{context, tree}
    Zipper(context, BinTree(v, tree.left, tree.right))
  }

  // Replace a left child tree.
  def setLeft[A](l: Option[BinTree[A]], zipper: Zipper[A]): Zipper[A] = {
    import zipper.tree
    Zipper(zipper.context, BinTree(tree.value, l, tree.right))
  }

  // Replace a right child tree.
  def setRight[A](r: Option[BinTree[A]], zipper: Zipper[A]): Zipper[A] = {
    import zipper.tree
    Zipper(zipper.context, BinTree(tree.value, tree.left, r))
  }
}

// A binary tree.
case class BinTree[A](value: A, left: Option[BinTree[A]], right: Option[BinTree[A]])

case class Context[A](point: A, dir: Boolean, container: Option[BinTree[A]])

case class Zipper[A](context: List[Context[A]], tree: BinTree[A])
