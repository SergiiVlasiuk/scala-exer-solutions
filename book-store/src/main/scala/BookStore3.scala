object BookStore3 {
  private val costs = List(0, 800, 1520, 2160, 2560, 3000)

  private def getCost(ints: List[Int]): Int = {

    @annotation.tailrec
    def inner(list: List[Int], acc: Int): Int = list match {
      case Nil => acc
      case _ =>
        val distinct = list.distinct
        inner(list.diff(distinct), costs(distinct.size) + acc)
    }

    inner(ints, 0)
  }

  private def getGroups(i: Int, books: List[Int]): Iterator[Int] = {
    books.combinations(i).map {
      x => getCost(x) + getCost(books.diff(x))
    }
  }

  def total(books: List[Int]): Int = {
    if (books.isEmpty) 0
    else books
      .indices
      .flatMap(i => getGroups(i + 1, books))
      .min
  }
}
