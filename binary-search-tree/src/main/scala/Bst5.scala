case class Bst5[A: Ordering](value: A, left: Option[Bst5[A]] = None, right: Option[Bst5[A]] = None) {
  def insert(x: A): Bst5[A] =
    if(implicitly[Ordering[A]].lteq(x, value)) copy(left = left.map(_.insert(x)).orElse(Some(Bst5(x))))
    else copy(right = right.map(_.insert(x)).orElse(Some(Bst5(x))))

  def foldRight[B](z: B)(f: (A, B) => B): B = {
    val rz = right.map(_.foldRight(z)(f)).getOrElse(z)
    val zz = f(value, rz)
    val lz = left.map(_.foldRight(zz)(f)).getOrElse(zz)
    lz
  }
}

object Bst5 {
  def toList[A](xs: Bst5[A]): List[A] =
    xs.foldRight[List[A]](Nil)(_ +: _)

  def fromList[A : Ordering](xs: Seq[A]): Bst5[A] = {
    require(!xs.isEmpty)

    xs.tail.foldLeft(Bst5(xs.head))(_ insert _)
  }
}
