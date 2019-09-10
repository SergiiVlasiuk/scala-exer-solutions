object Change4 {
  type Coins = List[Int]

  private def getCoins(v: Int, coins: Coins): Coins =
    coins.filter(_ <= v).foldRight(Nil: Coins) {
      case (i, r) =>
        if (r.exists(_ % i == 0)) r
        else i :: r
    }

  def findFewestCoins(v: Int, coins: Coins, r: Coins = Nil): Option[Coins] =
    if (v == 0) Some(r.sorted)
    else if (coins.isEmpty) None
    else if (v < coins.head) None
    else if (v < 0) None
    else getCoins(v, coins).map(i => findFewestCoins(v - i, coins, i :: r))
      .filter(_.isDefined)
      .sortBy(_.get.size).headOption.getOrElse(None)
}