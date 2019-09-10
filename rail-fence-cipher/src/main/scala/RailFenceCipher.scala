object RailFenceCipher {
  def encode(text: String, howManyRails: Int): String =
    cipher(text.length, howManyRails) map { i => text(i._1) } mkString

  def decode(cipherText: String, howManyRails: Int): String =
    cipher(cipherText.length, howManyRails) sortBy (_._1) map { i => cipherText(i._2) } mkString

  private def cipher(textLength: Int, howManyRails: Int): Seq[(Int, Int)] = {
    val railIndices = makeRailIndices(howManyRails) zip (0 until textLength)
    railIndices.sortBy(_._1).zipWithIndex.map {
      case ((railId, encodeIndex), decodeIndex) => (encodeIndex, decodeIndex)
    }
  }

  private def makeRailIndices(n: Int): Stream[Int] = {
    val xs = (1 to n).toList
    val ys = xs ++ xs.reverse.tail.init
    Stream.continually(ys.toStream).flatten
  }
}