object Experiment extends App {
  override def main(args: Array[String]): Unit = {
    val reg = """\\W""".r
    val string = "one,two,three"
    val str = string.replaceAll("\\W"," ")
    println(str)
    println(reg.replaceAllIn(str, " "))


    val wordCharacters = """[^A-z'\d]""".r
    val stringToInt =
      wordCharacters.split("car: carpet as java: javascript!!&@$%^&")
        //    wordCharacters.replaceAllIn(words, " ")
        //      .replaceAll("^", "")
        //      .split(" ")
        .filterNot(_.isEmpty)
        .map(_.toLowerCase)
//        .map(_.trim)
        .map(_.replaceAll("^\'|\'$", ""))
        .foldLeft(Map[String, Int]()) {
          (acc, word) => (acc + (word -> (acc.getOrElse(word, 0) + 1)))
        }
    println(stringToInt)

    val stringToInt2 =
      wordCharacters.split("car: carpet,,, as java: javascript!!&@$%^&")
        //    wordCharacters.replaceAllIn(words, " ")
        //      .replaceAll("^", "")
        //      .split(" ")
        .filterNot(_.isEmpty)
        .toList
    println(stringToInt2)

  }
}
