object PythagoreanTriplet {
  def pythagoreanTriplets(min: Int, max: Int): Seq[(Int, Int, Int)] =
    (min to max).combinations(3).toList.map(l => (l(0), l(1), l(2))).filter(isPythagorean)

  def isPythagorean(trip: (Int, Int, Int)): Boolean = {
    //    val list = trip.productIterator.toList.map(x => Math.pow(x.toString.toInt, 2)).sorted
    //    list(0) + list(1) == list(2)
    val a :: b :: c :: Nil = trip.productIterator.toList.map(x => Math.pow(x.toString.toInt, 2)).sorted
    a + b == c
  }
}
