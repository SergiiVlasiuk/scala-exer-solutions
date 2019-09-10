import scala.util.Random

case class Cipher(key: String) {
  private val startChar = 'a'.toInt

  private def encodeChar(charKey: Char, actual: Char): Char =
    (math.abs(actual + charKey - 2 * startChar) % 26 + startChar).toChar

  private def decodeChar(charKey: Char, actual: Char) =
    (math.abs(actual - charKey) % 26 + startChar).toChar

  private def transform(input: String, fun: (Char, Char) => Char) =
    key.zip(input).map { case (pivot, actual) => fun(pivot, actual) }.mkString

  def encode(phrase: String): String = transform(phrase, encodeChar)

  def decode(phrase: String): String = transform(phrase, decodeChar)
}

object Cipher {
  val letters = 'a' to 'z'

  def generateKey() = (0 until 100).map(_ => letters(Random.nextInt(letters.length))).mkString

  def apply(pivot: Option[String]): Cipher = pivot match {
    case Some(value) if value.isEmpty => throw new IllegalArgumentException()
    case Some(value) if value.exists(x => x.isUpper || x.isDigit) => throw new IllegalArgumentException()
    case None => new Cipher(generateKey)
    case Some(value) => new Cipher(value)
  }
}
