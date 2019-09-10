case class WordCount3(words: String) {
  def countWords(): Map[String, Int] = {
    words
      .split("[^\\w']+")
      .filter(_.nonEmpty)
      .map(_.toLowerCase)
      .map(_.stripPrefix("'"))
      .map(_.stripSuffix("'"))
      .sorted
      .groupBy(identity)
      .mapValues(x => x.size)
  }
}