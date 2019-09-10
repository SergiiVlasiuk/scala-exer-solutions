object RomanNumerals2 {
  def roman(number: Int): String = new RomanNumerals2(number).value

  val Numerals = List(
    1000 -> "M",
    900 -> "CM",
    500 -> "D",
    400 -> "CD",
    100 -> "C",
    90 -> "XC",
    50 -> "L",
    40 -> "XL",
    10 -> "X",
    9 -> "IX",
    5 -> "V",
    4 -> "IV",
    1 -> "I"
  )
}

class RomanNumerals2(val number: Int) {
  def unfoldRight[A, B](seed: B)(f: B => Option[(A, B)]): List[A] = f(seed) match {
    case Some((a, b)) => a :: unfoldRight(b)(f)
    case None => Nil
  }

  lazy val value = unfoldRight(number) {
    // Each time, take the largest value <= n and subtract it
    n =>
      RomanNumerals2.Numerals.find {
        _._1 <= n
      } map {
        case (value, numerals) => (numerals, n - value)
      }
  }.mkString
}
