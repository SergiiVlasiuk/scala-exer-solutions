

object Name {
  def unapply(input: String) = {
    val pos = input.indexOf(" ")
    if (pos == -1) None
    else Some(input.substring(0, pos), input.substring(pos + 1))
  }
}

object IntConverter {
  def unapply(input: Int): String = input match {
    case 3 => "three"
    case 5 => "five"
    case 10 => "ten"
  }
}

object Main extends App {

  val personName = "FirstName LastName"
  val Name(firstName, lastName) = personName
  println(firstName + " Last: " + lastName)

  val input: Int = 30
  println(myParser(input))

  def myParser(input: Int): String = List(3, 5, 10).filter(input % _ == 0) match {
    case ls if ls isEmpty => input toString
    case ls => ls mkString
  }
/*
  def myParser(input: Int): String =
    List(3, 5, 10).filter(input % _ == 0).map{_ match{
      case IntConverter() => IntConverter
    }}
*/




/*
  def divisorUnapply:Divisor=>Option[Double] = match {

    // unapply method is called here.
    case Divisor(div) =>
      print("Divisor: " + div)

    case _            => print("Not able to extract properly!!!")
  }
  divisorUnapply(Divisor(50))
  divisorUnapply(Divisor(13))
*/
val divisor = Divisor(50) // divisor will be 10
  divisor match {

    // unapply method is called here.
    case Divisor(div) => print("Divisor: " + div)
    case _ => print("Not able to extract properly!!!")
  }
}

object Divisor {

  def apply(x: Double): Double = x / 5

  def unapply(z: Double): Option[Double] = {
    if (z % 5 == 0) {
      Some(z / 5)
    } else {
      None
    }
  }
}
