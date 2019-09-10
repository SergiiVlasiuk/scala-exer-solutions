object Series {
  def slices(count: Int, number: String) = number map (_.asDigit) sliding (count) toList
}
