object ScrabbleScore4 {
  private val letterScores: Map[Int, Seq[Char]] =
    Map(
      1 -> Seq('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
      2 -> Seq('D', 'G'),
      3 -> Seq('B', 'C', 'M', 'P'),
      4 -> Seq('F', 'H', 'V', 'W', 'Y'),
      5 -> Seq('K'),
      8 -> Seq('J', 'X'),
      10 -> Seq('Q', 'Z')
    )

  def score(word: String): Int = word.map(scoreLetter).sum

  def scoreLetter(c: Char): Int = findScore(c).getOrElse(0)

  private def findScore(c: Char): Option[Int] =
    letterScores.find(_._2.contains(c.toUpper)).map(_._1)
}
