object Diamond {
  private val firstChar = 'A'
  private val fillingChar = " "

  def rows(inputChar: Char): List[String] = {
    def makeLine(letterCount: Int, indexedChar: (Char, Int)) = {
      val (char, row) = indexedChar
      val outerSpaces = fillingChar * (letterCount - row - 1)
      val innerSpaces = fillingChar * (if (char == firstChar) 0 else row * 2 - 1)

      if (char == firstChar) s"$outerSpaces$char$outerSpaces"
      else s"$outerSpaces$char$innerSpaces$char$outerSpaces"
    }

    val letters = (firstChar to inputChar).zipWithIndex
    (letters ++ letters.reverse.tail) map(makeLine(letters.length, _)) toList
  }
}
