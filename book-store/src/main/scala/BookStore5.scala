import scala.annotation.tailrec

object BookStore5 {

  def total(list: List[Int]) = {
    if (list.size > 0) {
      list
        .zipWithIndex
        .flatMap { case (_, i) => computeDeals(list, i + 1) }
        .min
    } else 0.0
  }

  private def computeDeals(list: List[Int], i: Int) = {
    list
      .combinations(i)
      .map(_.toList)
      .toList
      .map { case subList: List[Int] =>
        price(subList) + price(list.diff(subList))
      }
  }

  private def price(list: List[Int]) = {
    @tailrec
    def price(list: List[Int], sum: Double): Double = {
      list match {
        case Nil => sum
        case _ =>
          val distinct = list.distinct
          price(list.diff(distinct), sum + catalogue(distinct.size))
      }
    }

    price(list, 0.0)
  }

  val corePrice = 800.0
  val catalogue = Map(
    0 -> 0.0,
    1 -> corePrice,
    2 -> 2 * corePrice * 0.95,
    3 -> 3 * corePrice * 0.9,
    4 -> 4 * corePrice * 0.8,
    5 -> 5 * corePrice * 0.75)
}