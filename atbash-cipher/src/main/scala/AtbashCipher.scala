object AtbashCipher {
  val pairs = {
    val alphabet = 'a' to 'z'
    alphabet.zip(alphabet.reverse).toMap
  }

  def decode(input: String): String = input
    .replaceAll(""" |\+|\p{P}""", "")
    .toLowerCase
    .map(c => pairs.getOrElse(c, c))

  def encode(phrase: String): String = decode(phrase).grouped(5).mkString(" ")
}
