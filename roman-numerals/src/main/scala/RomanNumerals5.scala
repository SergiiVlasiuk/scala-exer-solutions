import scala.annotation.tailrec

case class RomanNumerals5(number: Int) {
  lazy val roman: String = computeRomanNumeral(number)

  private val arabicToRomanConversionMarkers = Map(
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

  @tailrec private def computeRomanNumeral(number: Int, romanNumeral: String = ""): String = {
    if (number == 0) return romanNumeral
    val highestMarker = arabicToRomanConversionMarkers.keys.toList.sortWith(_ > _).maxBy(_ <= number)
    val highestRomanNumeral = arabicToRomanConversionMarkers(highestMarker)
    computeRomanNumeral(number - highestMarker, s"$romanNumeral$highestRomanNumeral")
  }
}

object RomanNumerals5 {
  def roman(i: Int) = RomanNumerals5(i).roman
}