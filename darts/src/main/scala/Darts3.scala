object Darts3 {
  def score(x: Double, y: Double): Int = x * x + y * y match {
    case res if res > 100 => 0
    case res if res > 25 => 1
    case res if res > 1 => 5
    case _ => 10
  }
}