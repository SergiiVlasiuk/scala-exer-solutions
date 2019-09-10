object Darts {
  def score(x: Double, y: Double): Int = math.hypot(x, y) match {
    case res if res <= 1 => 10
    case res if res <= 5 => 5
    case res if res <= 10 => 1
    case _ => 0
  }
}
