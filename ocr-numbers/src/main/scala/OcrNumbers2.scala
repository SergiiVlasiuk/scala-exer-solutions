object OcrNumbers2 {
  def convert(input: List[String]): String = {
    input.grouped(4).map { case Seq(first, second, third, fourth) =>
      (first zip second zip third zip fourth).map {
        case (((a, b), c), d) => (a.toString, b.toString, c.toString, d.toString)
      }.grouped(3).map { case Seq(a, b, c) =>
        Digit(
          a._1 + b._1 + c._1,
          a._2 + b._2 + c._2,
          a._3 + b._3 + c._3,
          a._4 + b._4 + c._4).value
      }.mkString
    }.mkString(",")
  }
}

case class Digit(first: String, second: String, third: String, fourth: String) {
  def value: Char = this match {
    case Digit(" _ ", "| |", "|_|", "   ") => '0'
    case Digit("   ", "  |", "  |", "   ") => '1'
    case Digit(" _ ", " _|", "|_ ", "   ") => '2'
    case Digit(" _ ", " _|", " _|", "   ") => '3'
    case Digit("   ", "|_|", "  |", "   ") => '4'
    case Digit(" _ ", "|_ ", " _|", "   ") => '5'
    case Digit(" _ ", "|_ ", "|_|", "   ") => '6'
    case Digit(" _ ", "  |", "  |", "   ") => '7'
    case Digit(" _ ", "|_|", "|_|", "   ") => '8'
    case Digit(" _ ", "|_|", " _|", "   ") => '9'
    case _ => '?'
  }
}
