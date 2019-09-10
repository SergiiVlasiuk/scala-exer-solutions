// solution is borrowed form Wows's
object Change {
  type Change = Option[List[Int]]

  def findFewestCoins(totalPay: Int, coins: List[Int]): Change = {
    @annotation.tailrec
    def loop(pay: Int, resM: Map[Int, Change]): Map[Int, Change] = {
      if (pay > totalPay) resM else {
        loop(pay + 1, resultFor(pay, resM))
      }
    }

    def resultFor(pay: Int, resM: Map[Int, Change]): Map[Int, Change] = {
      val results = coins.filter(_ <= pay)
        .foldLeft(List[Change]())((cs, coin) => resM(pay - coin).map(coin :: _) :: cs)

      val result = if (results.flatten.isEmpty) None else Some(results.flatten.minBy(_.length).sorted)
      resM + (pay -> result)
    }

    if (totalPay < 0) None else
      loop(1, Map(0 -> Some(List())))(totalPay)
  }
}
