import scala.util.Random

object Cipher3 {
  def apply(key: Option[String]) = {
    require(key.isEmpty || isValidKey(key.get))
    new Cipher3(key.getOrElse(defaultKey))
  }
  def isValidKey(key: String) = !key.isEmpty && key.forall(isValidKeyChar)
  def isValidKeyChar(c: Char) = c.isLower && c.isLetter
  def defaultKey = Random.alphanumeric.filter(isValidKeyChar).take(100).toList.mkString
}

case class Cipher3(key: String) {

  def encode(s: String): String = shiftChars(s)(keyShiftByIndex)
  def decode(s: String): String = shiftChars(s)(keyUnshiftByIndex)

  private def keyShiftByIndex(index: Int): Int = fromA(key.charAt(index % key.length))
  private def keyUnshiftByIndex(index: Int): Int = -keyShiftByIndex(index)

  private def shiftChars(s: String)(shiftByIndex: Int => Int): String =
    s.zipWithIndex.map { case (char, index) => cyclicShift(char, shiftByIndex(index)) }.mkString

  private def cyclicShift(char: Char, shift: Int): Char = shiftA((26 + fromA(char) + shift) % 26)
  private def fromA(char: Char): Int = char - 'a'
  private def shiftA(dist: Int): Char = ('a' + dist).toChar
}
