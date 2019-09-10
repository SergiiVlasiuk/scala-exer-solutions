object NthPrime {
  val primes: Stream[Int] = 2 #:: Stream.from(3, 2).filter(isPrime)

  def isPrime(number: Int): Boolean =
    primes.takeWhile(_ <= math.sqrt(number)).forall(number % _ != 0)

  def prime(n: Int): Option[Int] = n match {
    case 0 => None
    case _ => Some(primes.take(n).last)
  }
}
