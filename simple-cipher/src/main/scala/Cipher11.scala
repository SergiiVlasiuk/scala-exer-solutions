import scala.util.Random

case class Cipher11(pivot: Option[String]) {
  val key: String = pivot match {
    case None => val r = Random
      (1 to 100).map(_ => (r.nextInt(26) + 97).toChar).mkString
    case Some(value) =>
      if (value.isEmpty || value.exists(x => !x.isLower)) throw new IllegalArgumentException()
      value
  }

  private def encodeChar(pivot: Char, actual: Char) = {
    val asciiCode = actual + (pivot - 97)
    if (asciiCode > 122) (asciiCode - 26).toChar else asciiCode.toChar
  }

  private def decodeChar(pivot: Char, actual: Char) = {
    val asciiCode = actual - (pivot - 97)
    if (asciiCode < 97) (asciiCode + 26).toChar else asciiCode.toChar
  }

  private def transform(input: String, f: (Char, Char) => Char) = key.zip(input)
    .map { case (pivot, actual) => f(pivot, actual) }.mkString

  def encode(phrase: String): String = transform(phrase, encodeChar)

  def decode(phrase: String): String = transform(phrase, decodeChar)
}
