object Minesweeper {
  def annotate(list: List[String]): List[String] = {
    if (list.isEmpty) return list
    val matrix = list.map(_.toList)
    matrix.indices.map(i => matrix(i).indices.map(j => calcCells(i, j, matrix)).mkString).toList
  }

  private def calcCells(x: Int, y: Int, matrix: List[List[Char]]): String = {
    if (matrix(x)(y) == '*') return "*"
    val s = (
      for {i <- x - 1 to x + 1
           if i >= 0 && i < matrix.length
           j <- y - 1 to y + 1
           if j >= 0 && j < matrix.head.length
      } yield if (matrix(i)(j) == '*') 1 else 0).sum
    if (s == 0) " "
    else s.toString
  }
}
