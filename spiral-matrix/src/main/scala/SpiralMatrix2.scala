object SpiralMatrix2 {
  def spiralMatrix(rank: Int): List[List[Int]] = {
    def constructMatrix(rows: Int, columns: Int, from: Int): List[List[Int]] = rows match {
      case 0 => List.empty
      case _ => (from until from + columns).toList :: constructMatrix(columns, rows - 1, from + columns).reverse.transpose
    }
    //if (rows == 0) List.empty
    //else (from until from + columns).toList :: constructMatrix(columns, rows - 1, from + columns).reverse.transpose

    constructMatrix(rank, rank, 1)
  }
}
