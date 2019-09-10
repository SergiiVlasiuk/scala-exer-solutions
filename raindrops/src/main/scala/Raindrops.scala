object Raindrops {

  val factors = Map(
    3 -> "Pling",
    5 -> "Plang",
    7 -> "Plong"
  )

  def convert(n: Int): String = factors.filterKeys(n % _ == 0).values.toList match {
    case Nil => n toString
    case ls => ls mkString
  }
}

