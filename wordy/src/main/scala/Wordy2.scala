import scala.annotation.tailrec

object Wordy2 {
  def answer(str: String): Option[Int] = apply(str)

  private lazy val questionPattern = """What is ([^?]+).?""".r
  private lazy val outputPattern = """(-?\d+)""".r
  private lazy val plusPattern = """(-?\d+) plus (-?\d+)(.*)""".r
  private lazy val minusPattern = """(-?\d+) minus (-?\d+)(.*)""".r
  private lazy val multiplyPattern = """(-?\d+) multiplied by (-?\d+)(.*)""".r
  private lazy val dividePattern = """(-?\d+) divided by (-?\d+)(.*)""".r
  private lazy val powerPattern = """(-?\d+) raised to the (-?\d+)(.*)""".r

  @tailrec
  private def calculate(q: String): Option[Int] = {
    q match {
      case outputPattern(v) => Some(v.toInt)
      case plusPattern(v1, v2, rest) => calculate((v1.toInt + v2.toInt).toString + rest)
      case minusPattern(v1, v2, rest) => calculate((v1.toInt - v2.toInt).toString + rest)
      case multiplyPattern(v1, v2, rest) => calculate((v1.toInt * v2.toInt).toString + rest)
      case dividePattern(v1, v2, rest) => calculate((v1.toInt / v2.toInt).toString + rest)
      case powerPattern(v1, v2, rest) => calculate(math.pow(v1.toInt, v2.toInt).toInt.toString + rest)
      case _ => None
    }
  }

  def apply(s: String): Option[Int] = s match {
    case questionPattern(q) => calculate(q)
    case _ => None
  }
}
