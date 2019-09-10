import org.scalatest._

import scala.collection.mutable

/** @version created manually **/
class RobotNameSpecs8 extends FunSpec with Matchers {
  val nameRegex = """[A-Z]{2}\d{3}"""

  it ("has a name") {
    new Robot8().name should fullyMatch regex nameRegex
  }

  it ("does not change its name") {
    val robot = new Robot8
    val name = robot.name
    println(name)
    robot.name should be (name)
  }

  it ("does not have the same name as other robots") {
    new Robot8().name should not be new Robot8().name
  }

  it ("can have its name reset") {
    val robot = new Robot8
    val name = robot.name
    robot.reset()
    val name2 = robot.name
    name should not equal name2
    name2 should fullyMatch regex nameRegex
  }

  // Making this test pass is an optional extra exercise, should you want more of a challenge.
  // It's ignored by default, to make it run, simply change "ignore" below to "it".
  // There are 26^2 * 1,000 = 676,000 possible robot names - you have to ensure that none are repeated.
  // The Robot8 code needs to be efficient enough to allow all 676,000 unique names to be generated.
//  ignore("a large number of new instances have unique names") {
  it ("a large number of new instances have unique names") {
    val alreadySet = mutable.HashSet.empty[String]
    for(_ <- 0 until 676000 - 6) { // as 6 robot names are generated in the tests above!!
      val name = new Robot8().name
      if (alreadySet contains name) {
        fail(s"$name is repeated")
      }
      alreadySet += name
    }
  }
}
