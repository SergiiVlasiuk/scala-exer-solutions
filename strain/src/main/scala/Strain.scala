object Strain {
  def keep[T](input: Seq[T], pred: T => Boolean): List[T] = input.filter(pred).toList

  def discard[T](input: Seq[T], pred: T => Boolean): List[T] = keep(input, (x: T) => !pred(x))
}