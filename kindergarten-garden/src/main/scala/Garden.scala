object Plant extends Enumeration {
  val Grass, Clover, Violets, Radishes = Value

  val Abbreviations = Map(
    'G' -> Grass,
    'C' -> Clover,
    'V' -> Violets,
    'R' -> Radishes
  )
}

object Children {
  type Name = String
  type Names = List[Name]

  val Default = List(
    "Alice", "Bob", "Charlie", "David", "Eve", "Fred",
    "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"
  )
}

object Garden {
  type Layout = String

  def defaultGarden(layout: Layout) = new Garden(Children.Default, layout)
  def apply(children: Children.Names, layout: Layout) = new Garden(children.sorted, layout)
}

class Garden(children: Children.Names, layout: Garden.Layout) {
  val rows = layout.split("\n")

  private def childOffset(name: Children.Name) = children.indexOf(name) * 2
  private def plantsAt(offset: Int) =
    rows.flatMap { row => row.slice(offset, offset+2) }

  def plants(name: Children.Name) =
    plantsAt(childOffset(name)).map(Plant.Abbreviations)
}
