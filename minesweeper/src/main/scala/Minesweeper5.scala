class Minesweeper5(mines: List[String]) {
  type position = (Int, Int)

  val mine = '*'

  private val (r, c) = (mines.size, if(mines.isEmpty) 0 else mines.head.length)

  val minesLocations: IndexedSeq[(Int, Int)] = for {
    x <- 0 until r
    y <- 0 until c
    if mines(x)(y) == mine
  } yield (x, y)

  private val minesCounter: Map[position, Int] = minesLocations.foldLeft(Map[position, Int]())(
    (acc, c) => createCells(c).foldLeft(acc)((acc1, pos) => acc1.updated(pos, acc1.getOrElse(pos, 0) + 1))
  )

  private def isValid(pos: position): Boolean = (0 <= pos._1) && (pos._1 < r) && (0 <= pos._2) && (pos._2 < c) && (mines(pos._1)(pos._2) != mine)

  private def createCells(pos: position): List[position] = for {
    x <- (-1 to +1).toList
    y <- (-1 to +1).toList
    cell = (pos._1 + x, pos._2 + y)
    if isValid(cell)
  } yield cell

  def annotate(): List[String] = if (mines == Nil) Nil else (0 until r).toList.map(x => (0 until c).map(y => minesCounter.getOrElse((x, y), mines(x)(y))).mkString)

}

object Minesweeper5 {
  def annotate(mines: List[String]): List[String] = new Minesweeper5(mines).annotate()
}
