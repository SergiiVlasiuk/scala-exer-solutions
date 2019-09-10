object Luhn2 {
  private def dbl(t: (Int, Boolean)): Int = t match {
      case (n, false) => n
      case (n, true) if 2 * n > 9 => 2 * n - 9
      case (n, true) => 2 * n
    }

  private def dblSndDigitFromRight(xs: Seq[Int]): Seq[Int] = xs.reverse
      .zip((Stream continually List(false, true)).flatten)
      .map(dbl)
      .reverse

  def valid(s: String): Boolean = {
    val digitsOnly = s filter (_.isDigit)
    val nonDigitNonSpace = (c: Char) => !c.isDigit && !c.isSpaceChar
    if (digitsOnly.length < 2 || (s exists nonDigitNonSpace)) false
    else dblSndDigitFromRight(digitsOnly map (_.asDigit)).sum % 10 == 0
  }
}