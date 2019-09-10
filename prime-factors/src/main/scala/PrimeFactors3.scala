object PrimeFactors3 {
  def factors(input: Long): List[Long] = {
    def factorsRec(start: Long, input: Long): List[Long] = input match {
      case x if x == 1 => List()
      case _ if input % start == 0 => start :: factorsRec(start, input / start)
      case _ if input % start != 0 => factorsRec(start + 1, input)
    }

    factorsRec(2, input)
  }
}
