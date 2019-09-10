case class WordCount4(words: String) {
  private val wordCharacters = "[^\\w']+".r

  def countWords: Map[String, Int] = wordCharacters.split(words)
    .filter(_.nonEmpty)
    .map(_.toLowerCase)
    .map(_.trim)
    .map(_.replaceAll("^\'|\'$", ""))
    .foldLeft(Map[String, Int]()) {
      (acc, word) => (acc + (word -> (acc.getOrElse(word, 0) + 1)))
    }
}
