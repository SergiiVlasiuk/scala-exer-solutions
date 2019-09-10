object Series2 {
  def slices(n: Int, number: String) =
    if (number.isEmpty) List()
    else ((0 to number.length - n) map { e => number.substring(e, e + n).toList.map(_.asDigit) }).toList
}
