object AtbashCipher2 {
  def encode(sentence: String): String = decode(sentence.toLowerCase)
    .grouped(5)
    .mkString(" ")

  def decode: String => String = _.replaceAll(""" |\+|\p{P}""", "").map {
    case c if c.isLetter => ('z' - (c - 'a')).toChar
    case notLetter => notLetter
  }
}
