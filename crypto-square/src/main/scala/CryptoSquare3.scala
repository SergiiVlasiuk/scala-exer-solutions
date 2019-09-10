object CryptoSquare3 {
  def ciphertext(s: String): String = {
    @annotation.tailrec
    def toString(l: List[String], s: String, i: Int): String = {
      if (l.head.length <= i) s.dropRight(1)
      else toString(l, s + l.foldLeft("")((acc, s) => acc + s.charAt(i)) + " ", i + 1)
    }

    if (s.isEmpty) s else {
      val normalized = s.toLowerCase.filter(_.isLetterOrDigit)
      val rows = math.sqrt(normalized.length).round.toInt
      val cols = math.sqrt(normalized.length).ceil.toInt
      val spaces = rows * cols - normalized.length

      val l = (normalized + " " * spaces).grouped(cols).toList

      toString(l, "", 0)
    }
  }
}