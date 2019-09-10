object NthPrime2 {
  val primes = Stream.from(2).filter(isPrime)

  private def isPrime(number: Int): Boolean = (2 to math.sqrt(number).toInt).forall(number % _ != 0)

  def prime(n: Int): Option[Int] = n match {
    case m if m <= 0 => None
    case m => Some(primes(m - 1))
  }
}