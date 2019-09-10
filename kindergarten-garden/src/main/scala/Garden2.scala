import Plant2.Plant2

class Garden2(l1: String, l2: String) {

  import Garden2.getIndex
  import Plant2.getPlant2

  def plants(name: String): List[Plant2] = {
    val index = getIndex(name)
    val strings = l1.substring(2 * index, 2 * index + 2) ++ l2.substring(2 * index, 2 * index + 2)
    strings.map(getPlant2).toList
  }
}

object Garden2 {

  def getIndex(name: String): Int = "ABCDEFGHIJKL".indexOf(name.head)

  def defaultGarden2(str: String): Garden2 = {
    val l1 :: l2 :: _ = str.split("\n").toList
    new Garden2(l1, l2)
  }

}

object Plant2 extends Enumeration {
  type Plant2 = Value
  val Radishes, Clover, Grass, Violets = Value
  def getPlant2(c: Char): Plant2 = c match {
    case 'R' => Radishes
    case 'C' => Clover
    case 'G' => Grass
    case 'V' => Violets
    case _ => throw new Exception("ooops")
  }
}
