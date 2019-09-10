class RomanNumerals(num: Int) {
  lazy val roman = RomanNumerals.thousands(index(1000)) +
    RomanNumerals.hundreds(index(100)) +
    RomanNumerals.tens(index(10)) +
    RomanNumerals.ones(index(1))

  def index(digit: Int): Int = num % (digit * 10) / digit
}

object RomanNumerals {
  def roman: Int => String = num => new RomanNumerals(num).roman

  val ones = List("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
  val tens = List("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
  val hundreds = List("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
  val thousands = List("", "M", "MM", "MMM")
}
