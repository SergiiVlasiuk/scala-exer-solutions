object Cipher8 {
  private val random = scala.util.Random
  private val chars = 'a' to 'z'
  private def nextChar() = chars(random.nextInt(chars.length))
  private def randomKey(): String = (1 to 100).map(_ => nextChar()).mkString("")
}
case class Cipher8(rawKey: Option[String]) {
  val key = rawKey match {
    case Some(k) =>
      require(!k.exists(_.isUpper))
      require(!k.exists(_.isDigit))
      require(k.nonEmpty)
      k
    case _       => Cipher8.randomKey()
  }
  private val steps = key.map(_ - 'a')

  private def convert(s: String)(op: (Char, Int) => Int): String = s.zip(steps).map {
    case (c, step) => ((op(c, step) - 'a') % 26 + 'a').toChar
  }.mkString("")

  def encode(in: String): String = convert(in)(_ + _)
  def decode(in: String): String = convert(in)(_ - _)
}
