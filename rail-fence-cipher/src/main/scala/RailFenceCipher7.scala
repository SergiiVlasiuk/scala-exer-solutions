object RailFenceCipher7 {

  def index(text: String, numOfRails: Int): Seq[Int] = {
    val index = for{
      row <- 0 until numOfRails
      col <- (row until text.length by ((numOfRails - 1) * 2))
    } yield
      if(row != 0 && row != numOfRails -1 && col + numOfRails - 1 < text.length)
        Array(col, col + (numOfRails - 1 - row) * 2)
      else
        Array(col)
    index.flatten
  }

  def encode(plain: String, numOfRails: Int): String = {
    val idx = index(plain, numOfRails)
    idx.map(idx => plain(idx)).mkString
  }

  def decode(cipher: String, numOfRails: Int) = {
    val idx = index(cipher, numOfRails)
    (idx zip cipher).sortBy(_._1).map(_._2).mkString
  }
}