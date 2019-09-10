object Garden4 {
  private val children = Seq("Alice", "Bob", "Charlie", "David", "Eve",
    "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")

  def defaultGarden4(diagram: String) = Garden4(children, diagram)

}

case class Garden4(_children: Seq[String], diagram: String) {

  val children = _children.sorted

  private def pos(name: String) = children.indexOf(name)

  private val split = diagram.split("\n").toSeq

  private def get2[T](s: Seq[T], idx: Int) = s grouped 2 toList idx

  private def getInitials(name: String) = if (pos(name) < 0) Nil else split.flatMap(get2(_, pos(name)))

  def plants(name: String) = getInitials(name).flatMap(i => Plant4.values.find(_.toString.head == i))
}

object Plant4 extends Enumeration {
  type Plant4 = Value
  val Radishes, Grass, Clover, Violets = Value
}