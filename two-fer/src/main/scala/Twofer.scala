object Twofer {
  def twofer(name: String): String = Option(name).map(_.trim).filter(_.length > 0) match {
    case None => "One for you, one for me."
    case Some(x) => s"One for $x, one for me."
  }

  def twofer(): String = twofer(null)

////  community solutions:
//def twofer(whom: String = "you") = s"One for $whom, one for me."

}
