object Change6 {
  def findFewestCoins(amount: Int, coins: Seq[Int]): Option[Seq[Int]] = {
    findFewestCoins2(amount, coins.sorted(Ordering.Int.reverse)).map(_.sorted)
  }

  private def findFewestCoins2(amount: Int, coins: Seq[Int]): Option[Seq[Int]] = {
    if (amount == 0) Some(Nil)
    else if (coins.isEmpty || amount < 0) None
    else {
      val coin = coins.head
      val options = ((amount / coin) to 1 by -1).toStream

      val validResults = options.flatMap { count => spendCoins(amount, coin, count, coins.tail) }.headOption
      val validResultsWithoutThisCoin = findFewestCoins2(amount, coins.tail).toSeq

      (validResults.toSeq ++ validResultsWithoutThisCoin)
        .sortBy(_.length)
        .headOption
    }
  }

  private def spendCoins(amount: Int, coin: Int, count: Int, rest: Seq[Int]) = {
    val spent = (1 to count).map(_ => coin)
    findFewestCoins2(amount - (count * coin), rest).map(rest => spent ++ rest)
  }
}