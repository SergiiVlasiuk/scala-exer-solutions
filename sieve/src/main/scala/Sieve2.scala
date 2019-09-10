object Sieve2 {
  def primes(limit: Int): List[Int] = {
    var list = (2 to limit).toList

    list.foldRight(List[Int]())((_, acc) =>
      if (list.isEmpty) acc
      else {
        val current = list.head
        println(s"limit: $limit, current: $current, acc: $acc, list: $list")
        list = list.filter(_ % current != 0)
        acc :+ current
      }
    )
  }
}