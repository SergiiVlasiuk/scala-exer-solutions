object PigLatin3 {
  def translate(phrase: String): String = {
    phrase.split(" ").map(PigLatinWord3(_)).mkString(" ")
  }
}

object PigLatinWord3 {
  val vowelRegx = """([aeiou]{1,}[a-z]{1,})""".r
  val consRegx = """([^aeiou]{1,})([aeiou]{1,}[a-z]{1,})""".r
  val quRegx = """([^aeiou]{0,}qu)([a-z]{1,})""".r

  def apply(word: String): String = {
    def addSuffix(chars: String) = {
      chars + "ay"
    }

    word match {
      case vowelRegx(chars) => addSuffix(chars)
      case quRegx(first, next) => addSuffix(next + first)
      case consRegx(first, next) => addSuffix(first + next)
    }
  }
}