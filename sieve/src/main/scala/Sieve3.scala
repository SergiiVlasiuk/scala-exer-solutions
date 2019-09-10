object Sieve3 {
  //Note: I really liked stania1's answer, so I redid my solution to understand it completely.
  def primes(end: Int): List[Int] = {
    val values = (2 to end).toList
    values.foldLeft(values) { (list, current) =>
      //item == current:     take the next available unmarked number in your list (it is prime)
      //item % current != 0: mark all the multiples of that number (they are not prime)
      println(s"end: $end, current: $current, list: $list")
      list.filter(item => item == current || item % current != 0)
    }
  }
}
