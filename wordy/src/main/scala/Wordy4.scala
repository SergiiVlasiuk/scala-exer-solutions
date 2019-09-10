trait Wordy4 {
  def q: String
}

object Wordy4 {
  def answer(str: String) = apply(str)

  val mathOps = Set("plus", "minus", "multiplied", "divided", "raised")

  def apply(q: String): Option[Int] = {
    calculate(validate(parse(q)))
  }

  def parse(q: String): Array[String] = {
    q.split(' ')
      .map(_.toLowerCase)
      .map(_.replaceAll("(\\?|\\,|th)", ""))
      .filter((w) => mathOps.contains(w) || scala.util.Try(w.toInt).toOption != None)
      .reverse
  }

  def validate(qp: Array[String]): Array[String] = {
    if (qp.size <= 2 || qp.size % 2 == 0) {
      return Array[String]()
    }
    for (i <- 1 until qp.size) {
      if ((mathOps.contains(qp(i)) && mathOps.contains(qp(i - 1))) ||
        (!mathOps.contains(qp(i)) && !mathOps.contains(qp(i - 1)))) {
        return Array[String]()
      }
    }
    qp
  }

  def calculate(qp: Array[String]): Option[Int] = {
    if (qp.size == 0) {
      None
    } else if (qp.size == 1) {
      Some(qp.head.toInt)
    } else {
      qp(1) match {
        case "plus" => Some(calculate(qp.slice(2, qp.size)).get + qp.head.toInt)
        case "minus" => Some(calculate(qp.slice(2, qp.size)).get - qp.head.toInt)
        case "multiplied" => Some(calculate(qp.slice(2, qp.size)).get * qp.head.toInt)
        case "divided" => Some(calculate(qp.slice(2, qp.size)).get / qp.head.toInt)
        case "raised" => Some(Math.pow(calculate(qp.slice(2, qp.size)).get, qp.head.toInt).toInt)
      }
    }
  }
}