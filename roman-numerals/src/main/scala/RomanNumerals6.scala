case class RomanNumerals6(number: Int, roman: String = "This property is not for input!")

object RomanNumerals6 {
  def roman(n: Int): String = RomanNumerals6(number = n).roman

  private def unfoldRight[A, B](seed: B)(f: B => Option[(A, B)]): List[A] = f(seed) match {
    case Some((a, b)) => a :: unfoldRight(b)(f)
    case None => Nil
  }

  def apply(number: Int) = new RomanNumerals6(number, unfoldRight(number) { n =>
    Numerals.find {
      _._1 <= n
    } map { case (value, numerals) => (numerals, n - value) }
  }.mkString)

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
