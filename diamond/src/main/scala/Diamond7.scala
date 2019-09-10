object Diamond7 {
  def rows(letter: Char): List[String] = {
    def makeLine(letterCount: Int, indexedLetter: (Char, Int)) = {
      val (char, row) = indexedLetter
      val outerSpaces = "".padTo(letterCount - row - 1, " ").mkString
      val innerSpaces = "".padTo(if (row == 0) 0 else row * 2 - 1, " ").mkString

      if (char == 'A') s"$outerSpaces$char$outerSpaces"
      else s"$outerSpaces$char$innerSpaces$char$outerSpaces"
    }

    val letters = ('A' to letter).zipWithIndex
    val allLetters = letters ++ letters.reverse.tail
    allLetters.map(makeLine(letters.length, _)).toList
  }
}