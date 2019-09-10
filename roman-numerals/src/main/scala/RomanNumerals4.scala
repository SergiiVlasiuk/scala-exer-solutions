object RomanNumerals4 {

  val maxRoman: Int = 3888

  private val numeralData: List[(Char, Char, Char)] = List(
    ('M', ' ', ' '),
    ('C', 'D', 'M'),
    ('X', 'L', 'C'),
    ('I', 'V', 'X')
  )

  private def f(unit: Char, five: Char, ten: Char, n: Int): List[Char] =
    n match {
      case _ if n < 4 => List.fill(n)(unit)
      case 4          => List(unit, five)
      case _ if n < 9 => five :: List.fill(n - 5)(unit)
      case 9          => List(unit, ten)
      case _          => Nil
    }

  private def g(n: Int): Option[String] =
    if (n < 0 || n > maxRoman)
      None
    else {
      val toStr = (xs: List[Char]) => xs mkString ""
      val fromStr = (s: String) => s.toCharArray.map(_.asDigit).toList
      val m = n.toString
      val digits = fromStr("0" * (4 - m.length)) ::: fromStr(m)
      val pairs = numeralData zip digits
      Some(toStr(pairs flatMap {
        case ((unit, five, ten), a) => toStr(f(unit, five, ten, a))
      }))
    }

  def roman(n: Int): String =
    g(n) match {
      case Some(s) => s
      case None    => ""
    }

}