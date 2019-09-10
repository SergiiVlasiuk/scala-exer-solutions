object Bob {
  def response(statement: String): String =
    statement.trim match {
      case "" => "Fine. Be that way!"
      case s if yelling(s) && question(s) => "Calm down, I know what I'm doing!"
      case s if yelling(s) => "Whoa, chill out!"
      case s if question(s) => "Sure."
      case _ => "Whatever."
    }
  private def yelling: String => Boolean = _.filter(_.isLetter).matches("[A-Z]+")
  private def question: String => Boolean = _.matches(".*\\?")

}