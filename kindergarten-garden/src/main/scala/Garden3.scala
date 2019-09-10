object Plant3 {

  sealed trait Plant3

  case object Clover extends Plant3
  case object Grass extends Plant3
  case object Violets extends Plant3
  case object Radishes extends Plant3

  def letterToPlant3(char: Char): Plant3 = char match {
    case 'V' => Plant3.Violets
    case 'C' => Plant3.Clover
    case 'G' => Plant3.Grass
    case 'R' => Plant3.Radishes
  }
}

case class Garden3(rows: String, kids: Seq[String]) {
  import Plant3.{Plant3, letterToPlant3}

  def extractAndTransform(row: String, drop: Int): List[Plant3] = row.drop(drop).take(2).map(letterToPlant3).toList

  def plants(child: String): List[Plant3] = {
    val Array(row1, row2, _*) = rows.split("\n")
    val startPosition = kids.indexOf(child) * 2
    extractAndTransform(row1, startPosition) ::: extractAndTransform(row2, startPosition)
  }
}

object Garden3 {
  private val kids = Array(
    "Alice", "Bob", "Charlie", "David",
    "Eve", "Fred", "Ginny", "Harriet",
    "Ileana", "Joseph", "Kincaid", "Larry"
  )
  def defaultGarden3(rows: String): Garden3 = new Garden3(rows, kids)
}