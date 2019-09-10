case class Subject(item: String, action: String)

object House4 {
  val subjects = List(
    Subject("the house that Jack built", "lay in"),
    Subject("the malt", "ate"),
    Subject("the rat", "killed"),
    Subject("the cat", "worried"),
    Subject("the dog", "tossed"),
    Subject("the cow with the crumpled horn", "milked"),
    Subject("the maiden all forlorn", "kissed"),
    Subject("the man all tattered and torn", "married"),
    Subject("the priest all shaven and shorn", "woke"),
    Subject("the rooster that crowed in the morn", "kept"),
    Subject("the farmer sowing his corn", "belonged to"),
    Subject("the horse and the hound and the horn", "")
  )

  private def getLine(x: Int): String = subjects.slice(0, x).reverse.zipWithIndex.map {
    case (s, i) =>
      if (i == 0) s"This is ${s.item}"
      else s"that ${s.action} ${s.item}"
  }.mkString("", " ", ".\n")

  def recite(i: Int, i1: Int): String = {
    (i to i1).map(getLine).mkString("", "", "\n")
  }
}
