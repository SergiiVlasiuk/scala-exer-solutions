object RunLengthEncoding2 {

  def encode(str: String): String = str match {
    case "" => ""
    case _ => {
      val (run, rest) = str.span(_ == str.head)
      val runLength = if (run.length > 1) run.length.toString else ""

      runLength + str.head + encode(rest)
    }
  }

  def decode(str: String): String = str match {
    case "" => ""
    case _ => {
      val (digits, postDigits) = str.span(_.isDigit)
      val runLength = if (digits.length > 0) digits.toInt else 1
      val (c, rest) = postDigits.splitAt(1)

      c.toString * runLength + decode(rest)
    }
  }
}