object CryptoSquare2 {
  def ciphertext(inp: String): String = {
    if (inp.isEmpty) inp
    else {
      val newInp = normalize(inp)
      val sizes = gridSize(newInp.length)
      val finalInp = newInp.padTo(sizes._1 * sizes._2, ' ')
      finalInp.map(_.toLower).split("").sliding(sizes._1, sizes._1).toArray.transpose.flatten.mkString.grouped(sizes._2).toList.mkString(" ")
    }
  }

  def gridSize(inp: Int): (Int, Int) = {
    val base = math.sqrt(inp).floor.toInt
    if (inp == base * base) (base, base)
    else if (inp > base * (base + 1)) (base + 1, base + 1)
    else (base + 1, base)

  }

  def normalize(inp: String): String = inp.map(_.toLower).replaceAll("[\\W]|_", "")
}
