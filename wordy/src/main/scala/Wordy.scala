import scala.util.parsing.combinator.RegexParsers

object Wordy extends RegexParsers {
  private def constant: Parser[Int] = """\-?\d+""".r ^^ { value => value.toInt }

  private def beginning = """\D*\s+""".r

  private def expr: Parser[Int] = beginning ~> constant ~ rep("plus" ~ constant | "minus" ~ constant | "multiplied by" ~ constant | "divided by" ~ constant) ~ "?" ^^ {
    case number ~ list ~ _ => (number /: list) {
      case (x, "plus" ~ y) => x + y
      case (x, "minus" ~ y) => x - y
      case (x, "multiplied by" ~ y) => x * y
      case (x, "divided by" ~ y) => x / y
    }
  }

  def answer(text: String): Option[Int] = parseAll(expr, text) match {
    case Success(value, _) => Some(value)
    case allElse => None // Error, Failure, NoSuccess
  }
}
