object FoodChain4 {

  def recite(first: Int, last: Int): String = {

    def animal(n: Int, details: Boolean = false) = {
      val animals = List("fly", "spider", "bird", "cat", "dog", "goat", "cow", "horse")

      if (n == 1 && details) "spider that wriggled and jiggled and tickled inside her"
      else animals(n)
    }

    def comment(n: Int): String = {
      val comments = List("", "It wriggled and jiggled and tickled inside her.", "How absurd to swallow a bird!", "Imagine that, to swallow a cat!",
        "What a hog, to swallow a dog!", "Just opened her throat and swallowed a goat!", "I don't know how she swallowed a cow!", "She's dead, of course!")
      val c = comments(n)
      if (c != "") c ++ "\n" else ""
    }

    def reasons(n: Int): String = {
      n match {
        case 0 => "I don't know why she swallowed the fly. Perhaps she'll die.\n"
        case 7 => ""
        case n => s"She swallowed the ${animal(n)} to catch the ${animal(n - 1, details = true)}.\n" ++ reasons(n - 1)
      }
    }

    def verse(n: Int): String = {
      var prologue = s"I know an old lady who swallowed a ${animal(n)}.\n"
      prologue ++ comment(n) ++ reasons(n)
    }

    val verses = for (n <- first to last) yield verse(n - 1)
    verses.mkString(start = "", sep = "\n", end = "\n")
  }
}