object PigLatin4 {
  val consonants = "^(rh|ch|thr|th|sch|qu|squ|[^aeiou])(.*)".r
  val specialVowel = """^(yt|xr)(.*)""".r

  def ay(plain: String): String =
    plain match {
      case specialVowel(startWith, xs) =>
        println(s"startWith: $startWith, xs: $xs, plain: $plain")
        startWith + xs + "ay"
      case consonants(startWith, xs) => xs + startWith + "ay"
      case _ => plain + "ay"
    }

  def translate(plain: String): String =
    plain.split("\\s")
      .map(ay)
      .mkString(" ")
}