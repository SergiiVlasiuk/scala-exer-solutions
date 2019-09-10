object NthPrime4 {
  def isPrime(n: Int) = !(2 to math.sqrt(n).toInt).exists(n % _ == 0)

  def prime(n: Int) = n match {
    case x if x<=0 => None
    case _ => Some(Stream.from(2).filter(isPrime).drop(n-1).head)
  }
}
