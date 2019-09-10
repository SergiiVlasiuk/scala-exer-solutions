object AllYourBase3 {
  def unfoldLeft[A, B](seed: B)(f: B => Option[(B, A)]): Seq[A] = {
    def loop(seed: B)(ls: List[A]): List[A] =
      f(seed) match {
        case Some((b, a)) => loop(b)(a :: ls)
        case None => ls
      }

    loop(seed)(Nil)
  }

  def from10(nr: Int, base: Int) =
    unfoldLeft(nr)(x => if(x>0) Option((x/base, x%base)) else None)

  def validDigit(base: Int, digit: Int) =
    Option(digit).filter(0 <= _).filter(_ < base)

  def to10(base: Int, digits: Seq[Int]) =
    digits.foldLeft(Option(0)) { (acc, digit) =>
      for {
        decimal <- acc
        d <- validDigit(base, digit)
      } yield decimal * base + d
    }

  def validBase(base: Int) =
    Option(base).filter(_ > 1)

  def rebase(from: Int, digits: Seq[Int], to: Int) =
    for {
      f <- validBase(from)
      t <- validBase(to)
      dec <- to10(f, digits)
    } yield from10(dec, t)
}