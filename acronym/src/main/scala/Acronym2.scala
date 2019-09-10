object Acronym2 {
  def abbreviate(phrase: String): String = {
    phrase.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2")

      .split("\\s|\\-")
      .filterNot(_.isEmpty)
      .map(x => x(0).toUpper).mkString
  }
}