object Luhn3 {
  def valid(str: String): Boolean = str.trim.length match {
    case 1 => false
    case 0 => false
    case _ => {
      val trimmedStr = str.filterNot(c => c isWhitespace)
      if (trimmedStr.exists(c => !c.isDigit)) false
      else {
        luhnAlgorithm(trimmedStr)
      }
    }
  }

  private def luhnAlgorithm(trimmedStr: String) = {
    val odd = trimmedStr.indices.partition(idx => idx % 2 == 0)._2.map(idx => trimmedStr.reverse(idx).asDigit)
    val even = trimmedStr.indices.partition(idx => idx % 2 == 0)._1.map(idx => trimmedStr.reverse(idx).asDigit)
    (odd.map(_ * 2).map(i => if (i > 9) i - 9 else i).sum + even.sum) % 10 == 0
  }
}