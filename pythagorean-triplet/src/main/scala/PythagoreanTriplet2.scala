object PythagoreanTriplet2 {
  //  def isPythagorean(tuple: (Int, Int, Int)): Boolean = ???

  def pythagoreanTriplets(min: Int, max: Int) =
    Seq.range(min, max).combinations(3).map { case a :: b :: c :: Nil if isPythagorean((a, b, c)) => (a, b, c) }

  def isPythagorean(triple: (Int, Int, Int)) = {
    val a :: b :: c :: Nil = triple.productIterator.toList.map(_.toString.toInt).sorted
    a * a + b * b == c * c
  }
}
