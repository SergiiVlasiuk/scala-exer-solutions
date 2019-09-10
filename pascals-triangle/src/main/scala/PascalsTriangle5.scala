object PascalsTriangle5 {
  def rows(n: Int): List[List[Int]] = n match {
    case 1 => List(List(1))
    case i if i < 1 => List()
    case i =>
      val prev = rows(i - 1)
      prev :+ (0 +: prev.last :+ 0).sliding(2).map(_.sum).toList
  }
}
