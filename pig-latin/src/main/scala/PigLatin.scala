object PigLatin{
  def translate(phrase: String): String = {
    phrase.split("\\s").map(translateWord).mkString(" ")
  }

  def translateWord(phrase: String): String = {
    val specialVowel = """^(yt|xr)(.*)""".r
    val consonant = """^(qu|y|[^aeiouy]qu|[^aeiouy]+)(.*)""".r
    val prefix = phrase match {
      case specialVowel(first, last) => first + last
      case consonant(first, last) => last + first
      case _ => phrase
    }
    prefix ++ "ay"
  }
}