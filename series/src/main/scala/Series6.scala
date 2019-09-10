object Series6 {
  def slices(n: Int, str: String):List[List[Int]] = {
    if(n > str.length)List()
    else str.sliding(n).map(_.toList.map(_.asDigit)).toList
  }
}