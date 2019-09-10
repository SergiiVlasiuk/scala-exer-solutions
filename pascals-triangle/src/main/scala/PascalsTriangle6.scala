object PascalsTriangle6 {
  def rows(n: Int): List[List[Int]] = {
    def nextRow(xs: List[Int]) = (0 +: xs zip xs :+ 0).map(x => x._1 + x._2)

    var res = List(List(1))
    if (n < 1) List.empty
    else {
      for (i <- 2 to n) res = res :+ nextRow(res.last)
      res
    }
  }
}
