object Strain2 {
  def keep[T](ls: Seq[T], f: T => Boolean): Seq[T] = ls match {
    case Nil => List[T]()
    case x :: xs if (f(x)) => x +: keep(xs, f)
    case x :: xs => keep(xs, f)
  }

  def discard[T](ls: Seq[T], f: T => Boolean): Seq[T] = {
    keep(ls, !f(_: T))
  }
}
