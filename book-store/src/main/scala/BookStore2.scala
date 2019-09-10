object BookStore2 {
  private val BookPrice = 800

  private def sortByFrequency(books: Seq[Int]): Seq[Int] =
    books.groupBy(identity).values.toList.sortBy(-_.length).flatten

  private def bookGroups(books: Seq[Int], maxSize: Int): List[List[Int]] = books match {
    case Nil => List()
    case remaining =>
      val group = {
        val group = remaining.distinct.toList
        group.take(math.min(group.length, maxSize))
      }
      group :: bookGroups(books.diff(group), maxSize)
  }

  private def priceForGroup(group: Seq[Int]): Int = (group.length match {
    case 2 => BookPrice * 2 * 0.95
    case 3 => BookPrice * 3 * 0.9
    case 4 => BookPrice * 4 * 0.8
    case 5 => BookPrice * 5 * 0.75
    case count => BookPrice * count
  }).asInstanceOf[Int]

  def total(books: Seq[Int]): Int =
    Seq(3, 4, 5).map(bookGroups(sortByFrequency(books), _).map(priceForGroup).sum).min
}
