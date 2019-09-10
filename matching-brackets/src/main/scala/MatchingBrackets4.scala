object MatchingBrackets4 {
  val brackets = "[]{}()".toSet

  def isPaired(input: String) = {
    def replaceMatchingBrackets: String => String =
      _.replace("[]", "")
        .replace("{}", "")
        .replace("()", "")

    def loop(remainder: String): Boolean = {
      if (remainder.isEmpty) {
        true
      }
      else {
        val updated = replaceMatchingBrackets(remainder)
        if (updated.length == remainder.length) {
          false
        }
        else {
          loop(updated)
        }
      }
    }

    val filtered = input.filter(brackets)
    loop(filtered)
  }

}