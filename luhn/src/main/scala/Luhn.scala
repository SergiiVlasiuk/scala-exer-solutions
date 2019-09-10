object Luhn {
  def valid: String => Boolean = cardNo => Some(cardNo).filter(validFormat).filter(validLuhn).isDefined

  private def validLuhn(cardNo: String): Boolean =
    cardNo.replaceAll("\\D", "").map(_.asDigit).reverse.zipWithIndex.map {
      case (d, idx) if idx % 2 == 0 => d
      case (d, _) if d > 4 => 2 * d - 9
      case (d, _) if d <= 4 => 2 * d
    }.sum % 10 == 0

  private def validFormat(cardNo: String): Boolean = atLeastNDigits(2)(cardNo) && validRegex(cardNo)

  private def validRegex: String => Boolean = s => """[\d ]{2,}""".r.pattern.matcher(s).matches

  private def atLeastNDigits: Int => String => Boolean = n => s => s.filter(Character.isDigit).size >= n
}
