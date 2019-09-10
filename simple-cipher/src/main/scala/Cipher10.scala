class Cipher10(val key: String) {
  private val first = 'a'
  private val offsets = key.map(_.toInt - 'a')

  def encode(text: String): String = text
    .zipWithIndex
    .map { case (char, idx) => ('a' + (char + offsets(idx) - 'a') % 26).toChar }
    .mkString("")

  def decode(text: String): String = text
    .zipWithIndex
    .map { case (char, idx) => ('a' + (char - offsets(idx) - 'a') % 26).toChar }
    .mkString("")
}

object Cipher10 {
  def apply(key: Option[String]): Cipher10 = {
    val k = key.map(validate).getOrElse {
      val random = for (i <- 0 until 10) yield ('a' + ((Math.random() * i) % 26)).toChar
      random.mkString("")
    }
    new Cipher10(k)
  }

  private def validate(key: String): String = {
    if (key.nonEmpty && key.forall(c => c.isLetter && c.toInt >= 'a')) key
    else throw new IllegalArgumentException(s"$key is not a valid key")
  }
}
