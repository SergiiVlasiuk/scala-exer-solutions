object Series4 {
  def slices(length: Int, series: String) : List[List[Int]] = {
    val subser = (start: Int) => series.substring(start, start + length).map(c => c.asDigit).toList
    (0 to (series.length() - length)).map(subser).toList
  }
}