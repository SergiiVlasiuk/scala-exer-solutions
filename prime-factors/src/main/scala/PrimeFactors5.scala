object PrimeFactors5 {
  def factors(num: Long): List[Int] = {
    def rec(count: Int, num: Long): List[Int] = num match {
      case _ if num == 1 => List.empty[Int]
      case _ if num == count => List(count)
      case _ if num % count > 0 => rec(count + 1, num)
      case _ if num % count == 0 => count :: rec(count, num / count)
    }

    rec(2, num)
  }
}
