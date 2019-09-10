case class WordCount2(str: String) {

  private val wordRegex = "[a-zA-Z'0-9]+"

  def countWords: Map[String, Int] = {
    val midString = str.split("[-.,:&?! \n]+")
      .filter(x => x.matches(wordRegex))
      .map(_.replaceAll("^\'|\'$", ""))
      .map(_.toLowerCase)
    //Map all the string
    val counted = midString.map(x => (x, 1)).groupBy(_._1).mapValues(seq => seq.map(_._2).sum)
    counted
  }

}