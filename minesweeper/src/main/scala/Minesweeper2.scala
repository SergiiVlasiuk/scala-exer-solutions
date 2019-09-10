object Minesweeper2 {
  def annotate(rows: List[String]): List[String] = {
    val nRows = rows.size
    val nCols = rows.map(_.size).fold(0) {_ max _}

    // with an extra border all around (+2s)
    // this way no extra logic for checking bounds
    // just have to trim the border 
    var anot = Array.ofDim[Int](nRows+2, nCols+2)

    for (
      (row, i) <- rows.zipWithIndex;
      (cell, j) <- row.zipWithIndex;
      if cell == '*') {

      anot(i+1)(j+1) += 9

      for (di <- -1 to 1;
           dj <- -1 to 1) {
        // index offset by +1 because of border
        anot(i+di+1)(j+dj+1) += 1
      }
    }

    var field = anot.map(_.map(_ match {
      case 0 => " "
      case i if i < 9 => i.toString
      case _ => "*"
    })).map(_.foldLeft("")(_+_))

    // trim border
    field = field.drop(1).dropRight(1)
    field = field.map(_.drop(1).dropRight(1))

    field.toList
  }
}
