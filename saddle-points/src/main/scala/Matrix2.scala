case class Matrix2(list: List[List[Int]]) {
  type IndexedRow = (List[Int], Int)
  type Element = ((Int, Int),Int)

  def saddlePoints() : Set[(Int, Int)] =  {
    def elmInRow(row : IndexedRow, c: (Int,Int) => Boolean) : List[Element] = row._1.zipWithIndex.foldLeft(List[Element]())(
      (acc,elm) => {
        if (!(acc.filter((ac1) => elm._1 == ac1._2).isEmpty)) ((row._2,elm._2),elm._1) :: acc
        else if (acc.filter((ac1) => c(ac1._2,elm._1)).isEmpty) List(((row._2,elm._2),elm._1))
        else acc
      })

    def maxes : List[Element] = list.zipWithIndex.flatMap(elmInRow(_, (_ > _)));

    // first transpose the matrix, then swap back rows with columns
    def mins : List[Element] = list.transpose.zipWithIndex.flatMap(elmInRow(_, (_ < _))).map( (elm : Element) => (elm._1.swap,elm._2));

    mins.filter(maxes.contains(_)).map(_._1).toSet

  }
}
