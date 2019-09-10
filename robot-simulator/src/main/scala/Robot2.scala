object Bearing2 extends PrevNextEnum {
  type Bearing2 = Value
  val North, East, South, West = Value
}

class PrevNextEnum extends Enumeration {
  lazy val previous = {
    val list = values.toList
    val map = (list.tail :+ list.head).zip(list).toMap
    v:Value => map.getOrElse(v, v)
  }

  lazy val next = {
    val list = values.toList
    val map = list.zip(list.tail :+ list.head).toMap
    v:Value => map.getOrElse(v, v)
  }
}

case class Robot2(bear : Bearing2.Value, cords : Tuple2[Int, Int]) {
  val bearing : Bearing2.Value = bear
  val coordinates : Tuple2[Int, Int] = cords

  def turnRight = new Robot2(Bearing2.next(bearing), coordinates)
  def turnLeft = new Robot2(Bearing2.previous(bearing), coordinates)

  def advance = bearing match {
    case Bearing2.North => new Robot2(bearing, (coordinates._1,  coordinates._2 + 1))
    case Bearing2.East => new Robot2(bearing, (coordinates._1 + 1,  coordinates._2))
    case Bearing2.South => new Robot2(bearing, (coordinates._1,  coordinates._2 - 1))
    case Bearing2.West => new Robot2(bearing, (coordinates._1 - 1,  coordinates._2 ))
  }

  def simulate(commands : String) = {
    def sim(commands: String, bot : Robot2) : Robot2 = commands.headOption match {
      case None => bot
      case Some('R') => sim(commands.tail, bot.turnRight)
      case Some('L') => sim(commands.tail, bot.turnLeft)
      case Some('A') => sim(commands.tail, bot.advance)
    }

    sim(commands, this)
  }
}