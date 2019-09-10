object Acronym {
  def abbreviate(phrase: String): String = """[^A-Za-z']""".r.split(phrase).filterNot(_.isEmpty)
    .map(_.charAt(0) toUpper) mkString
}
