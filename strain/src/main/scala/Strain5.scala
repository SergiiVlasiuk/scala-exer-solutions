object Strain5 {

  def keep[A](seq: Seq[A], func: A => Boolean): Seq[A] = {
    for (a: A <- seq if func(a)) yield a
  }

  def discard[A](seq: Seq[A], func: A => Boolean): Seq[A] = {
    for (a: A <- seq if !func(a)) yield a
  }
}