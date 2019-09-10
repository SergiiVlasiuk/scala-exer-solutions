import scala.util.Random

object Robot5 {
  private val chars = 'A' to 'Z'
  private val digits = 0 to 9

  private val random: Iterator[String] = {
    Stream.from(1).map(_ => randomName).distinct.iterator
  }

  private def randomName = {
    //    val letters = (0 until 2).map(_ => randomLetter()).mkString
    val numbers = (0 until 3).map(_ => randomDigit()).mkString
    //    letters + numbers
    numbers
  }


  //  private def randomLetter(): Char = shuffle[Char, IndexedSeq](chars).head
  //  private def randomDigit(): Int = Random.shuffle(digits).head
  private def randomDigit(): Int = Random.nextInt()
}

class Robot5() {

  var name = ""

  final def reset() {
    //    name = random.next()
//    name = Robot3.random()
  }

  reset()
}
