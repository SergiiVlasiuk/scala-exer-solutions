case class Cipher5(keyMaybe: Option[String]) {

  private val maxCharacter = 'z'.toInt

  private val minCharacter = 'a'.toInt

  private val lowercaseOnly ="[a-z]+".r

  val key : String = keyMaybe.getOrElse("a" * 100)

  require(lowercaseOnly.pattern.matcher(key).matches())

  def encode(text: String) : String = {
    val textAndKey = text.zip(key.take(text.length))
    textAndKey.map{case(c, k) => encode(c, k)}.mkString
  }

  def decode(text: String) : String = {
    val textAndKey = text.zip(key.take(text.length))
    textAndKey.map{case(c, k) => decode(c, k)}.mkString
  }

  private def encode(c: Char, key: Char) = {
    val encodedValue = c + (key - minCharacter)
    if (encodedValue > maxCharacter) (encodedValue - 26).toChar
    else encodedValue.toChar
  }

  private def decode(c: Char, key: Char) = {
    val decodedValue = c - (key - minCharacter)
    if (decodedValue < minCharacter) (decodedValue + 26).toChar
    else decodedValue.toChar
  }
}