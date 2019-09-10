object Sieve {
  //Note: I really liked ALRW's solution, so I redid my solution to understand it completely.
  def primes(limit: Int): List[Int] = {
    @scala.annotation.tailrec
    def sieve(initial: List[Int], primes: List[Int]): List[Int] = initial match {
      case Nil => primes
      case x :: xs =>
        //println(s"limit: $limit, filter by $x, income list: $initial")
        sieve(xs.filterNot(_ % x == 0), primes :+ x)
    }

    sieve((2 to limit).toList, List())
  }
}
