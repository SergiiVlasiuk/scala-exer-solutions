object RailFenceCipher12 {
  type Plain = String
  type Cipher = String

  def encode(text: Plain, howManyRails: Int): Cipher =
    cipher(text.length, howManyRails) map {
      i =>
        println(s"i: $i => ${i._1}")
        text(i._1)
    } mkString

  def decode(cipherText: Cipher, howManyRails: Int): Plain =
    cipher(cipherText.length, howManyRails) sortBy (_._1) map {
      i => cipherText(i._2)
    } mkString

  // mapping from original to encoded String index
  private def cipher(textLength: Int, howManyRails: Int): Seq[(Int, Int)] = {
    val railIndices = makeNewIndices(howManyRails) zip (0 until textLength)
    railIndices.sortBy(_._1).zipWithIndex.map {
      case (((rail, index), newIndex)) => (index, newIndex)
    }
  }
  private def makeNewIndices(n: Int): Stream[Int] = {
    val xs = (1 to n).toList
    val ys = xs ++ xs.reverse.tail.init
    Stream.continually(ys.toStream).flatten
  }
}