object Wordy6 {

  private val pattern = """([0-9-]*) ([a-z ]+) ([0-9-]+)""".r

  def answer(question: String) : Option[Int] = {
    val problem = question.replace("What is ", "").replace("?", "")
    val equations = pattern.findAllIn(problem).map(parse)

    val result = equations.foldLeft(0)((n, eq) => eq match {
      case (n1, op, n2) => calculate(n1.getOrElse(n), op, n2)
    })
    Some(result)
  }

  private def parse(equation: String) = equation match {
    case pattern(num1, op, num2) => {
      if (num1 == "") (None, op, num2.toInt)
      else (Some(num1.toInt), op, num2.toInt)
    }
  }

  private def calculate(num1: Int, op: String, num2: Int) = (num1, op, num2) match {
    case (n1, "plus", n2) => n1 + n2
    case (n1, "minus", n2) => n1 - n2
    case (n1, "multiplied by", n2) => n1 * n2
    case (n1, "divided by", n2) => n1 / n2
    case (n1, "raised to the", n2) => Math.pow(n1, n2).toInt
  }
}
