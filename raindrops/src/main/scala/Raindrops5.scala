object Raindrops5 {
  def convert(n: Int): String = List((3, "Pling"), (5, "Plang"), (7, "Plong")).filter(n % _._1 == 0) match {
    case Nil => n.toString
    case list => list.map(_._2).mkString
  }
}