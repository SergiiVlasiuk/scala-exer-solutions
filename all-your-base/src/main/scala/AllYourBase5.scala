object AllYourBase5 {
  def rebase(a : Int, number : List[Int], b : Int) : Option[List[Int]] = {
    if (a < 2 || b < 2 || nonValidInput(number, a)) None else {
      var numarray = List.empty[Int]
      var remaining = number.foldLeft(0){(acc, elem) => acc * a + elem}
      do {
        numarray = (remaining % b) :: numarray
        remaining = remaining / b
      } while (remaining > 0)
      Some(numarray.dropWhile(_==0))
    }
  }

  private def nonValidInput(num : List[Int], base : Int) = {
    num.size == 0 || num.head == 0 || num.filter(x => x>=base || x < 0).size > 0
  }

}