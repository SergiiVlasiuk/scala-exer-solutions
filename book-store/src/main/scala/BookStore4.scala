object BookStore4 {
  def total(cart: List[Int]): Int = if (cart.isEmpty) 0 else minPrice(cart)

  def minPrice(cart: List[Int]): Int = {
    val bookCounts = cart.groupBy(identity).mapValues(_.size)

    val nGroups = bookCounts.values.max
    val minBooks = bookCounts.values.count(_ == nGroups)

    val rs = List.fill(nGroups)(minBooks.to(5).toList)
    val wrapped = rs(0).map(List(_))

    val crossProd = rs.drop(1).foldLeft(wrapped) {
      cross
    }
    crossProd.filter(_.sum == cart.size).map(calcPrice).min
  }

  def cross[A](xss: List[List[A]], ys: List[A]): List[List[A]] =
    for (xs <- xss; y <- ys) yield y +: xs

  def calcPrice(grouped: List[Int]): Int =
    grouped.map(s => s * 8 * (100 - discount(s))).sum

  val discount = Map(1 -> 0, 2 -> 5, 3 -> 10, 4 -> 20, 5 -> 25)
}
