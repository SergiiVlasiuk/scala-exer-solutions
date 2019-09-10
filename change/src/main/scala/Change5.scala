object Change5 {
  def findMinCoins(amount: Int, coins: Seq[Int], mins: Map[Int, Seq[Int]]): Map[Int, Seq[Int]] =
    mins.get(amount) match {
      case Some(_) => mins
      case _       => coins
        .filter(_ <= amount)
        .flatMap { coin => mins.get(amount - coin).map(cs => coin +: cs) }
        .sortBy(_.length).headOption
        .map(cs => mins.updated(amount, cs))
        .getOrElse(mins)
    }

  def findFewestCoins(total: Int, coins: Seq[Int]): Option[Seq[Int]] =
    if (total == 0) Some(Seq())
    else {
      val coinMap = Map(coins.map(c => c -> Seq(c)) :+ (0 -> Seq(0)): _*)
      (coins.min to total).foldLeft(coinMap) { (currentMins, subtotal) =>
        findMinCoins(subtotal, coins, currentMins)
      }.get(total)
    }
}