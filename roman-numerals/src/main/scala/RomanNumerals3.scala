class RomanNumerals3(val number: Int, roman: String = "This property is not for input!")

object RomanNumerals3 {
  def roman(n: Int): String = new RomanNumerals3(n) match {
    case RomanNumerals3(num, rom) => rom
  }

  private def unfoldRight[A, B](seed: B)(f: B => Option[(A, B)]): List[A] = f(seed) match {
    case Some((a, b)) => a :: unfoldRight(b)(f)
    case None => Nil
  }

  def unapply(romanNumerals3: RomanNumerals3): Option[(Int, String)] = {
    println(s"unapply: romanNumerals3: $romanNumerals3")
    Some(romanNumerals3.number, unfoldRight(romanNumerals3.number) { n =>
      Numerals.find {
        _._1 <= n
      } map { case (value, numerals) => (numerals, n - value) }
    }.mkString)
  }

  //  def apply(number: Int) = new RomanNumerals3(number, "not for input")
  //
  //  def apply(number: Int) = new RomanNumerals3(number, unfoldRight(number) { n =>
  //    Numerals.find {
  //      _._1 <= n
  //    } map { case (value, numerals) => (numerals, n - value) }
  //  }.mkString)
  //
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
