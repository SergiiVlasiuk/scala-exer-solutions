object Wordy3 {

  implicit class RicherString(s: String) {
    def toOperator: (Int, Int) => Int = s match {
      case "plus" => _ + _
      case "minus" => _ - _
      case "multiplied by" => _ * _
      case "divided by" => _ / _
    }
  }

  private val Sentence = s"What is (-?\\d+) (.*?) (-?\\d+) ?(.*?)? ?(-?\\d+)?\\?".r

  def answer(question: String): Option[Int] = question match {
    case Sentence(a, op1, b, "", null) => Some(op1.toOperator(a.toInt, b.toInt))
    case Sentence(a, op1, b, op2, c) => Some(op2.toOperator(op1.toOperator(a.toInt, b.toInt), c.toInt))
    case _ => None
  }
}
