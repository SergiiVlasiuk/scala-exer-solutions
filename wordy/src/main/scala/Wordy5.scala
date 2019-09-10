object Wordy5 {
  lazy val operators: Map[String, (Int, Int) => Int] = Map(
    "plus" -> {
      _ + _
    },
    "minus" -> {
      _ - _
    },
    "multiplied by" -> {
      _ * _
    },
    "divided by" -> {
      _ / _
    },
    "raised to the" -> {
      math.pow(_, _).toInt
    }
  )

  lazy val Constant = "(-?[0-9]+)".r
  lazy val ops = operators.keys.mkString("|")
  lazy val Statement = s"(.*) ($ops) (-?[0-9]+)".r

  def solve(input: String): Option[Int] = input.trim match {
    case Constant(x) => Some(x.toInt)
    case Statement(expr, op, x) => solve(expr).map(operators(op)(_, x.toInt))
    case _ => None
  }

  def answer(input: String): Option[Int] = {
    solve(input.drop(8).toLowerCase.stripSuffix("?"))
  }
}
