object CryptoSquare {
  private def normalize(message: String): String = message.toLowerCase.replaceAll("[\\W]|_", "")

  private def numberRows(msgLength: Int): Int = Math.sqrt(msgLength).toInt

  def ciphertext(message: String): String = {
    if (message.isEmpty) ""
    else {
      val normalized = normalize(message)
      val numRows = numberRows(normalized.length)
      val numCols = if ((numRows * numRows) % normalized.length > 0) numRows + 1 else numRows
      val chunks: List[String] = normalized.sliding(numCols, numCols).toList.map(f => f.padTo(numCols, " ").mkString)
      (0 until numCols).map(idx => chunks.map(_ (idx))).toList.map(_.mkString).mkString(" ")
    }
  }
}
