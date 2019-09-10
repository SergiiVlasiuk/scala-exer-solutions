import org.scalatest.{FunSuite, Matchers}

/** @version 2.2.0 */
class Robot3SimulatorTest extends FunSuite with Matchers {

  test(
    "A robot is created with a position and a direction - Robots are created with a position and direction") {
    Robot3(Bearing3.North, (0, 0)) should be(Robot3(Bearing3.North, (0, 0)))
  }

  test("A robot is created with a position and a direction - Negative positions are allowed") {
    Robot3(Bearing3.South, (-1, -1)) should be(Robot3(Bearing3.South, (-1, -1)))
  }

  test("rotates the robot's direction 90 degrees clockwise - does not change the position") {
    Robot3(Bearing3.North, (0, 0)).turnRight.coordinates should be((0, 0))
  }

  test("rotates the robot's direction 90 degrees clockwise - changes the direction from north to east") {
    Robot3(Bearing3.North, (0, 0)).turnRight.bearing should be(Bearing3.East)
  }

  test("rotates the robot's direction 90 degrees clockwise - changes the direction from east to south") {
    Robot3(Bearing3.East, (0, 0)).turnRight.bearing should be(Bearing3.South)
  }

  test("rotates the robot's direction 90 degrees clockwise - changes the direction from south to west") {
    Robot3(Bearing3.South, (0, 0)).turnRight.bearing should be(Bearing3.West)
  }

  test("rotates the robot's direction 90 degrees clockwise - changes the direction from west to north") {
    Robot3(Bearing3.West, (0, 0)).turnRight.bearing should be(Bearing3.North)
  }

  test("rotates the robot's direction 90 degrees counter-clockwise - does not change the position") {
    Robot3(Bearing3.North, (0, 0)).turnLeft.coordinates should be((0, 0))
  }

  test("rotates the robot's direction 90 degrees counter-clockwise - changes the direction from north to west") {
    Robot3(Bearing3.North, (0, 0)).turnLeft.bearing should be(Bearing3.West)
  }

  test("rotates the robot's direction 90 degrees counter-clockwise - changes the direction from west to south") {
    Robot3(Bearing3.West, (0, 0)).turnLeft.bearing should be(Bearing3.South)
  }

  test("rotates the robot's direction 90 degrees counter-clockwise - changes the direction from south to east") {
    Robot3(Bearing3.South, (0, 0)).turnLeft.bearing should be(Bearing3.East)
  }

  test("rotates the robot's direction 90 degrees counter-clockwise - changes the direction from east to north") {
    Robot3(Bearing3.East, (0, 0)).turnLeft.bearing should be(Bearing3.North)
  }

  test("moves the robot forward 1 space in the direction it is pointing - does not change the direction") {
    Robot3(Bearing3.North, (0, 0)).advance.bearing should be(Bearing3.North)
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - increases the y coordinate one when facing north") {
    Robot3(Bearing3.North, (0, 0)).advance.coordinates should be((0, 1))
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - decreases the y coordinate by one when facing south") {
    Robot3(Bearing3.South, (0, 0)).advance.coordinates should be((0, -1))
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - increases the x coordinate by one when facing east") {
    Robot3(Bearing3.East, (0, 0)).advance.coordinates should be((1, 0))
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - decreases the x coordinate by one when facing west") {
    Robot3(Bearing3.West, (0, 0)).advance.coordinates should be((-1, 0))
  }

  test(
    "Where R = Turn Right, L = Turn Left and A = Advance, the robot can follow a series of instructions and end up with the correct position and direction - instructions to move west and north") {
    Robot3(Bearing3.North, (0, 0)).simulate("LAAARALA") should be(Robot3(Bearing3.West, (-4, 1)))
  }

  test(
    "Where R = Turn Right, L = Turn Left and A = Advance, the robot can follow a series of instructions and end up with the correct position and direction - instructions to move west and south") {
    Robot3(Bearing3.East, (2, -7)).simulate("RRAAAAALA") should be(Robot3(Bearing3.South, (-3, -8)))
  }

  test(
    "Where R = Turn Right, L = Turn Left and A = Advance, the robot can follow a series of instructions and end up with the correct position and direction - instructions to move east and north") {
    Robot3(Bearing3.South, (8, 4)).simulate("LAAARRRALLLL") should be(Robot3(Bearing3.North, (11, 5)))
  }
}
