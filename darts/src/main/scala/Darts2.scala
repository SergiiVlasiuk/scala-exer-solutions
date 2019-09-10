object Darts2 {
  implicit class DoubleOps(d: Double) {
    def **(power: Double): Double = math.pow(d, power)
  }

  def score(x: Double, y: Double): Int = x ** 2 + y ** 2 match {
    case i if i <= 1 => 10
    case i if i <= 25 => 5
    case i if i <= 100 => 1
    case _ => 0
  }
}