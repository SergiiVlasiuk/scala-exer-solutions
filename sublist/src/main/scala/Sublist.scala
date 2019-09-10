object Sublist extends Enumeration {
  val Equal, Sublist, Superlist, Unequal = Value

  def sublist[A](xs: List[A], ys: List[A]) = {
    if (xs == ys) Equal
    else if (xs containsSlice ys) Superlist
    else if (ys containsSlice xs) Sublist
    else Unequal
  }
}
