object PascalsTriangle2 {
  def rows(n: Int): List[List[Int]] = {
    if (n < 1) List()
    else _rows(n)
  }

  private def _rows(n: Int): List[List[Int]] = {
    if (n == 1) List(List(1))
    else {
      val prev = rows(n - 1)
      prev :+ ((1 :: (1 to n - 2).map(i => prev(n - 2)(i - 1) + prev(n - 2)(i)).toList) :+ 1)
    }
  }
}
