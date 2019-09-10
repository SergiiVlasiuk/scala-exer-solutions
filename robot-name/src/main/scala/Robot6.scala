import scala.collection.mutable
import scala.util.Random

class Robot6 {
  private val robotName: Option[String] = Some(randomName)
  private val usedNames = mutable.HashSet.empty[String]

  def name: String = robotName get

  final def reset(): Unit = {
    do{
      robotName.map(_ => randomName)
    } while (usedNames.contains(robotName get))
    usedNames add robotName.get
  }

  reset()

  def randomName: String = {
    val letters = Random.alphanumeric.filter(_.isLetter).take(2).mkString.toUpperCase
    val numbers = (Random.nextInt(900) + 100).toString
    println(s" $letters - $numbers ")
    letters + numbers
  }
}
