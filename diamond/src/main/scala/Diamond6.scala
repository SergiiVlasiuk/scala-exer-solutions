object Diamond6 {
  private def line(spaceOut: Int, letter: Char, spaceIn: Int): String = {
    if(spaceIn >= 0) {
      " " * spaceOut + letter + " " * (spaceIn * 2 + 1) + letter + " " * spaceOut
    } else {
      " " * spaceOut + letter + " " * spaceOut
    }
  }
  private def rowsRec(spaceOut: Int, letter: Char, spaceIn: Int): List[String] = {
    if(spaceOut == 0){
      List(line(0, letter, spaceIn))
    } else {
      line(spaceOut, letter, spaceIn) +:
        rowsRec(spaceOut - 1, (letter + 1).toChar, spaceIn + 1) :+
        line(spaceOut, letter, spaceIn)
    }
  }
  def rows(limit : Char): List[String] = {
    rowsRec(limit - 'A', 'A', -1)
  }
}