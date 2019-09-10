import scala.util.parsing.combinator.RegexParsers

object Wordy10 extends RegexParsers {
  private def constant: Parser[Int] = """\-?\d+""".r ^^ { value => value.toInt }

  private def expr: Parser[Int] = "What is" ~ constant ~ rep("plus" ~ constant | "minus" ~ constant | "multiplied by" ~ constant | "divided by" ~ constant) ~ "?" ^^ {
    case _ ~ number ~ list ~ _ => (list :\ number) {
      case ("plus" ~ y, x) => x + y
      case ("minus" ~ y, x) => x - y
      case ("multiplied by" ~ y, x) => x * y
      case ("divided by" ~ y, x) => x / y
    }
  }

  def answer(text: String): Option[Int] = parseAll(expr, text) match {
    case Success(value, _) => Some(value)
    case Error(message, input) => None
    case Failure(message, input) => None
    case obj: NoSuccess => None
    case allElse => None
  }
}
