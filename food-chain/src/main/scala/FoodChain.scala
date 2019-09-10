object FoodChain {
  val parts = Array[(String, String, String, String)](
    ("fly", "", "", "I don't know why she swallowed the fly. Perhaps she'll die.\n"),
    ("spider", " that wriggled and jiggled and tickled inside her", "It wriggled and jiggled and tickled inside her.\n", ""),
    ("bird", "", "How absurd to swallow a bird!\n", ""),
    ("cat", "", "Imagine that, to swallow a cat!\n", ""),
    ("dog", "", "What a hog, to swallow a dog!\n", ""),
    ("goat", "", "Just opened her throat and swallowed a goat!\n", ""),
    ("cow", "", "I don't know how she swallowed a cow!\n", ""),
    ("horse", "", "", "She's dead, of course!\n"))

  def recite(from: Int, till: Int): String =
    (for (num <- from to till) yield recite(num - 1)).mkString

  private def recite(num: Int): String =
    s"I know an old lady who swallowed a ${parts(num)._1}.\n${parts(num)._3}${append(num)}\n"

  private def append(num: Int): String = parts(num)._4 match {
    case "" => swallow(parts(num)._1, parts(num - 1)._1 + parts(num - 1)._2) + append(num - 1)
    case x => x
  }

  private def swallow(x1: String, x2: String) = s"She swallowed the $x1 to catch the $x2.\n"
}
