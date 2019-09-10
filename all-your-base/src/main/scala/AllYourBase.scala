object AllYourBase {
  def rebase(fromBase: Int, digits: List[Int], toBase: Int): Option[List[Int]] = {
    val invalidBase = fromBase < 2 || toBase < 2
    lazy val toDecimalValue: Int = digits.foldLeft(0)((total, digit) => (total * fromBase) + digit)

    def invalidDigit(digit: Int): Boolean = digit < 0 || digit >= fromBase

    def convertBase(decimal: Int): List[Int] =
      if (decimal < toBase) decimal :: Nil
      else (decimal % toBase)::convertBase(decimal / toBase)

    if (digits.exists(invalidDigit) || invalidBase) None
    else Some(convertBase(toDecimalValue).reverse)
  }
}
