case class WordCount(words: String) {
  //  def countWords: Map[String, Int] = ("[^\\w']+".r).split(words)
  def countWords: Map[String, Int] = words.split("[^\\w']+")
    .map(_.replaceAll("^\'|\'$", ""))
    .filter(_.nonEmpty)
    .map(_.toLowerCase)
    .groupBy(identity)
    .mapValues(x => x.size)
}
