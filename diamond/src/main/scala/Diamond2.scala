object Diamond2 {
  def drawRow(char: Char, innerSpaces: String, outerSpaces: String): String = char match {
    case 'A'  => s"$outerSpaces$char$outerSpaces"
    case  _ => s"$outerSpaces$char$innerSpaces$char$outerSpaces"
  }

  def createRow(row: (Char, Int), totalLength: Int): String = {
    val (char, index) = row
    val outerSpaces = " " * (totalLength - index - 1)
    val innerSpaces = if (index == 0) "" else " " * (index * 2 - 1)

    drawRow(char, innerSpaces, outerSpaces)
  }

  def rows(char: Char): List[String] = {
    val upperChars = ('A' to char).zipWithIndex
    val bottomChars = upperChars.reverse.tail

    val upper = upperChars map { createRow(_, upperChars.length) } toList
    val bottom = bottomChars.map{ createRow(_, upperChars.length) }.toList

    upper ::: bottom
  }
}
