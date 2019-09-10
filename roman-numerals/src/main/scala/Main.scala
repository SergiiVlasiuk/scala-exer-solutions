object Main extends App {

  private val fraction1 = Fraction(3, 4)
  println(s"Fraction declaration is processed: $fraction1")
  private val fraction2 = Fraction(2, 4)
  println(s"Fraction declaration is processed: $fraction2")
  private val fraction3: Fraction = fraction1 * fraction2
  println(s"Fraction multiply is processed: $fraction3")
  println(fraction3)

  //  val Fraction(numer, denom) = Fraction(1, 4) * Fraction(4, 5)
  val Fraction(numer, denom) = fraction3
  println(s"Fraction object to values: fraction1: $fraction1 || => Numerator: $numer, Denominator: $denom")
  println("================================================================")
  fraction3 match {
    case Fraction(3, 4) => println("case Fraction(3, 4) =>")
    case Fraction(6, y) => println(s"case Fraction(6, y) => , y: $y")
    case Fraction(x, y) => println(s"case Fraction(x, y) => , x: $x, y: $y")
  }
  val s: String = ""

  //  println("Numerator: " + numer + " Denominator: " + denom)
}

object Fraction {

  def apply(numer: Int, denom: Int) = {
    println(s"hello from apply: numerator: $numer, denominator: $denom")
    new Fraction(numer, denom)
  }

  def unapply(fraction: Fraction) = {
    println(s"hello from unapply: fraction: $fraction")
    if (fraction == null) None
    else Some(fraction.numerator, fraction.denominator)
  }

}

case class Fraction(var numerator: Int, var denominator: Int) {

  def *(fraction2: Fraction) = {

    Fraction(this.numerator * fraction2.numerator,
      this.denominator * fraction2.denominator)
  }

  override def toString = this.numerator + "/" + this.denominator
}
