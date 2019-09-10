object Diamond3 {
  val letters = 'A' to 'Z' toList

  def rows(char : Char): List[String] = {
    require(char.isUpper)
    val select = letters.takeWhile(_ <= char)
    val line = (select.tail.reverse:::select).mkString
    val picture = select.map(c => line.replaceAll("[^"+c+"]"," "))
    picture:::picture.reverse.tail
  }
}