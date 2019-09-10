import scala.collection.mutable
import scala.util.Random

object Robot7 {
  val nameRegex = """([A-Z]{2})(\d{3})""" r

  val iterator = Stream.from(1, 500).iterator
  var name = "AA000"
  var nameChars = "AA"
  var nameDigits = "000"
  val first = 'A'
  val dif: Int = 'Z' - 'A' + 1

  private def handleDigits(number: Int): (Int, String) = (iterator.next() + number) match {
    case next => (next / 1000, (next % 1000 + 1000).toString takeRight 3)
  }

  private def handleChars(chars: String, plus: Int): String = chars.map(_.toInt).toList match {
    case x :: y :: Nil =>
      val calc = y + plus - first
      s"${(calc / dif + first).toChar}, ${(calc % dif + first).toChar}"
  }

  def main(args: Array[String]): Unit = {
    println(handleDigits(2))
    println(handleDigits(2))
    println(handleDigits(2))
    println(handleDigits(2))
    println(handleDigits(2))
    println(handleChars("AA", 675))
    println(handleChars("AA", 26))
    var chars = "AA"
    var digits = 0
    //    name.map()
    println(s"('A' to 'Z') : ${('A' to 'Z').toList.size}")
    println(s"A: ${'A'.toShort}, Z: ${'Z'.toShort}, dif: $dif ")
    //    print(s"${name.toInt} ${name.toInt + 1} ${(name.toInt + 1).toString} ")
//    (0 to 10).map(a => iterator.next() + a).foreach(println)
    /*
        (0 to 676000).map {
          print(s"$name ")
          name + _
        }.foreach {
          case x if x.last == '0' => println(s"$x ")
          case x if x.last == '0' => print(s"$x ")
        }
    */
//    generate
//    generate
//    generate
//    generate
    generate
  }

  def generate: String = {
    iterator.next()
//    name.zipWithIndex.map {
//      case (ch, i) => println(s"$ch, $i")
//        (ch, i)
//    }
    name match {
      case nameRegex(alpha, number) =>
//        println(s"$alpha, $number")
//        number.toInt
        val halfRes = handleDigits(iterator.next())
//        println(s"$alpha, ${number.toInt + iterator.next()}")
//        println(s"${handleChars(alpha, halfRes._1)}, ${halfRes._2}")
        s"${handleChars(alpha, halfRes._1)}, ${halfRes._2}"
    }
  }
}

class Robot7 {
  private val robotName: Option[String] = Some("AA000")
  private val usedNames = mutable.HashSet.empty[String]

  def name: String = robotName get

  final def reset(): Unit = {
    do {
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
