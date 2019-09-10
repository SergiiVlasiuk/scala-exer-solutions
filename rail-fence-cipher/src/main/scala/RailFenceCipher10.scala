object RailFenceCipher10 {
  private def skips(rail: Int, rails: Int) = {
    val max = 2 * (rails - 1)
    if (rail == 0 || rail == rails - 1) Seq(max, max)
    else {
      val a = max - (2 * rail)
      Seq(a, max - a)
    }
  }

  private def indicesForRail(rail: Int, rails: Int, maxLength: Int) = {
    val rawSkips = skips(rail, rails)
    val expandedSkips = (0 to maxLength).map(i => rawSkips(i % 2))
    expandedSkips.foldLeft(Seq(rail)) { case (acc, next) => (acc :+ acc.last + next) }.filter(_ < maxLength)
  }

  def encode(in: String, rails: Int): String =
    (0 until rails).map { rail =>
      indicesForRail(rail, rails, in.length).map(i => in(i)).mkString
    }.mkString

  def decode(in: String, rails: Int): String =
    (0 until rails).flatMap { rail =>
      indicesForRail(rail, rails, in.length)
    }.zip(in.indices).map { case (pos, i) => pos -> in(i) }.sortBy(_._1).map(_._2).mkString
}