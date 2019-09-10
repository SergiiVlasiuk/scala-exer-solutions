object NthPrime3 {
  def prime(i: Int): Option[Int] = if (i < 1) None else
    Stream.from(2).filter(isPrime).drop(i - 1).headOption

  private def isPrime(n: Int) = (2 to Math.sqrt(n).toInt).forall(n % _ != 0)
}
