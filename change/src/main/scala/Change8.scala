object Change8 {
//  type Change8 = Option[List[Int]]

  def findFewestCoins(totalPay: Int, coins: List[Int]): Option[List[Int]] = {
//    @annotation.tailrec
    def loop(pay: Int, resM: Map[Int, Option[List[Int]]]): Map[Int, Option[List[Int]]] = {
      if (pay > totalPay) resM
      else loop(pay + 1, resultFor(pay, resM))
    }

    def resultFor(pay: Int, resM: Map[Int, Option[List[Int]]]): Map[Int, Option[List[Int]]] = {
      val results = coins.filter(_ <= pay)
        .foldLeft(List[Option[List[Int]]]())((cs, coin) => resM(pay - coin).map(coin :: _) :: cs)

      val result = if (results.flatten.isEmpty) None else Some(results.flatten.minBy(_.length).sorted)
      resM + (pay -> result)
    }

    if (totalPay < 0) {
      None
    }
    else loop(1, Map(0 -> Some(List())))(totalPay)
//    else {
//      val intToSomeList: Map[Int, Option[List[Int]]] = Map(0 -> Some(List()))
//      loop(1, intToSomeList)
//    }
  }
}