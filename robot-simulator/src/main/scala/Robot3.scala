import Bearing3.{Bearing3, East, North, South, West}

case class Robot3(bearing: Bearing3, coordinates: (Int, Int)) {

  def turnRight: Robot3 = {
    val newBearing3 = bearing match {
      case North => East
      case East => South
      case South => West
      case West => North
    }
    Robot3(newBearing3, coordinates)
  }

  def turnLeft: Robot3 = {
    val newBearing3 = bearing match {
      case North => West
      case East => North
      case South => East
      case West => South
    }
    Robot3(newBearing3, coordinates)
  }

  def advance: Robot3 = {
    val (x, y) = coordinates
    val newCoordinates = bearing match {
      case North => (x, y + 1)
      case East => (x + 1, y)
      case South => (x, y - 1)
      case West => (x - 1, y)
    }
    Robot3(bearing, newCoordinates)
  }

  def simulate(instruction: String): Robot3 =
    instruction.foldLeft(this) { (acc, op) =>
      op match {
        case 'L' => acc.turnLeft
        case 'R' => acc.turnRight
        case 'A' => acc.advance
      }
    }
}

object Bearing3 extends Enumeration {
  type Bearing3 = Value

  val North: Value = Value("North")
  val East: Value = Value("East")
  val South: Value = Value("South")
  val West: Value = Value("West")
}