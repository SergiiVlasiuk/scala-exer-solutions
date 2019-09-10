object RailFenceCipher9 {
  //Solution is from http://exercism.io/submissions/49ec62c6a8d54107b8db2c98c42ac3e6

  def index(text: String, numOfRails: Int): Seq[Int] = {
    def isInMiddleRow(row: Int): Boolean = (row != 0) && (row != numOfRails - 1)

    def idxOfNextElementInCurRow(row: Int, col: Int): Int = col + (numOfRails - (row + 1)) * 2

    //After one such step in text, you will go into an element which is at the same row.
    val step = (numOfRails - 1) * 2

    val allIdx = for {
      row <- 0 until numOfRails
      col <- row until text.length by step
    } yield {
      if (isInMiddleRow(row)) {
        val nextIdx = idxOfNextElementInCurRow(row, col)
        if(nextIdx < text.length) {
          Array(col, nextIdx)
        } else {
          Array(col)
        }
      } else {
        Array(col)
      }
    }
    allIdx.flatten
  }

  def encode(plain: String, numOfRails: Int): String = {
    index(plain, numOfRails).map(plain).mkString
  }

  def decode(cipher: String, numOfRails: Int): String = {
    index(cipher, numOfRails).zip(cipher).sortBy(_._1).map(_._2).mkString
  }
}
