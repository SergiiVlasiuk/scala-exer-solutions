import Bearing.{East, North, South, West}

case class Robot(bearing: Bearing, tuple: (Int, Int)) {

  def simulate(sim: String): Robot =
    sim.foldLeft(this) { (acc, op) =>
      op match {
        case 'L' => acc.turnLeft
        case 'R' => acc.turnRight
        case 'A' => acc.advance
      }
    }

  def turnRight(): Robot = Robot(bearing match {
      case North => East
      case East => South
      case South => West
      case West => North
    }, coordinates)

  def turnLeft(): Robot = Robot(bearing match {
      case North => West
      case East => North
      case South => East
      case West => South
    }, coordinates)

  def advance: Robot = bearing match {
    case Bearing.North => new Robot(bearing, (coordinates._1,  coordinates._2 + 1))
    case Bearing.East => new Robot(bearing, (coordinates._1 + 1,  coordinates._2))
    case Bearing.South => new Robot(bearing, (coordinates._1,  coordinates._2 - 1))
    case Bearing.West => new Robot(bearing, (coordinates._1 - 1,  coordinates._2 ))
  }

  def coordinates() = tuple

}

sealed class Bearing

object Bearing {

  case object North extends Bearing

  case object South extends Bearing

  case object East extends Bearing

  case object West extends Bearing

}