case class Garden5(children: List[String], plants: String) {

  private lazy val rows: Array[String] = plants.split('\n')
  private lazy val sorted = children.sorted

  private def slice(row: String, i: Int) = row.slice(i * 2, i * 2 + 2)

  def plants(child: String) = sorted.indexOf(child) match {
    case -1 => Nil
    case i => (for (row <- rows; plant <- slice(row, i)) yield plant.toString).toList
//    case i => (for (row <- rows; plant <- slice(row, i)) yield plant.toString).toList
//    case _ => Nil
  }

}

object Garden5 {

  private[this] val children = List(
    "Alice", "Bob", "Charlie", "David",
    "Eve", "Fred", "Ginny", "Harriet",
    "Ileana", "Joseph", "Kincaid", "Larry"
  )

  def defaultGarden5(plants: String) = Garden5(children, plants)

}

object Plant5 {

  val Grass = "G"
  val Clover = "C"
  val Radishes = "R"
  val Violets = "V"

}