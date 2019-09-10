case class Matrix3(matrix: List[List[Int]]) {
  def saddlePoints(): Set[(Int, Int)] = {
    matrix.zipWithIndex.foldLeft(Set[(Int, Int)]())((set, row) => {
      if (row._1.nonEmpty) {
        val max: (Int, Int) = row._1.zipWithIndex.maxBy(_._1)
        if (max._1 == matrix.transpose.toList(max._2).min)
          set + ((row._2, max._2))
        else set
      } else set
    })
  }
}
