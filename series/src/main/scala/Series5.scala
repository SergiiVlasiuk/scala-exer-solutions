object Series5 {
  def slices(size: Int, nr: String): List[List[Int]] = nr.map(_.asDigit).sliding(size).map(_.toList).toList
}
