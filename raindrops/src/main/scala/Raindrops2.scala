object Raindrops2 {

  implicit class RichIntFactors(n: Int) {
    lazy val factors: List[Int] = 1.to(n).map {
      case x if (1 to n).find(x * _ == n).getOrElse(-1) != -1 => (1 to n).find(x * _ == n).getOrElse(-1)
      case x => -1
    }.toList
  }

  def convert(n: Int): String = {
    val f = n.factors
    val code = "" + (if (f.contains(3)) "Pling" else "") + (if (f.contains(5)) "Plang" else "") + (if (f.contains(7)) "Plong" else "")
    if (code.length > 1) code else n.toString
  }
}

