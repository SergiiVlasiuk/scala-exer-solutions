import scala.collection.mutable

object BookStore {
  private val cache = mutable.Map[List[Int], Int]()
  private val discount: Map[Int, Double] = Map(1 -> 1, 2 -> 0.95, 3 -> 0.9, 4 -> 0.8, 5 -> 0.75)
  private val corePrice: Int = 800

  def total(books: List[Int]): Int = cache.getOrElseUpdate(books, getTotal(books))

  private def getTotal(books: List[Int]): Int = books match {
    case List() => 0
    case _ => books.toSet.subsets.filter(_.nonEmpty)
      .map(group => price(group) + total(books diff group.toList)).min
  }

  private def price(group: Set[Int]): Int = (corePrice * group.size * discount(group.size)).toInt
}
