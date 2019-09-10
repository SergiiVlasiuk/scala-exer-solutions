object AllYourBase7 {
  def rebase(fromBase: Int, digits: List[Int], toBase: Int): Option[List[Int]] = {
    val invalidDigit: Int => Boolean = digit => digit < 0 || digit >= fromBase

    val invalidBase =  fromBase < 2 || toBase < 2

    val toDecimalValue: Int = digits.foldLeft(0)((total, digit) => (total * fromBase) + digit)

    val validatedDecimal: Option[Int] =
      if (digits.exists(invalidDigit) || invalidBase) None
      else Some(toDecimalValue)

    def convertBase(decimal: Option[Int], toBase: Int, acc: List[Int]): Option[List[Int]] =
      decimal match {
        case None => None
        case Some(0) => if (acc.isEmpty) Some(List(0)) else Some(acc)
        case Some(n) => convertBase(Some(n / toBase), toBase, acc.+:(n % toBase))
      }

    convertBase(validatedDecimal, toBase, List())
  }
}