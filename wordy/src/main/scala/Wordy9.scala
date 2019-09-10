object Wordy9 {
  private val isQuestion = """What is (.*)\?""".r
  private val isSum = """(.*) plus (.*)""".r
  private val isSub = """(.*) minus (.*)""".r
  private val isMul = """(.*) multiplied by (.*)""".r
  private val isDiv = """(.*) divided by (.*)""".r
  private val isRaised = """(.*) raised to the (.*)""".r
  private val isNumber = """(-?\d+)""".r
  private val allOther = """(.*)""".r

  def operateOn(wordy: String): Int = wordy match {
    case isQuestion(s) => operateOn(s)
    case isDiv(left, right) => operateOn(left) / operateOn(right)
    case isMul(left, right) => operateOn(left) * operateOn(right)
    case isSum(left, right) => operateOn(left) + operateOn(right)
    case isSub(left, right) => operateOn(left) - operateOn(right)
    case isRaised(left, right) => math.pow(left.toDouble, right.toDouble).toInt
    case isNumber(n) => n.toInt
//    case allOther => None
  }

  def answer(wordy: String): Option[Int] = {
    Some(operateOn(wordy))
  }
}