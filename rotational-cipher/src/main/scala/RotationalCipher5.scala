object RotationalCipher5 {
  private val lowercases: List[Int] = List.iterate(97, 26)(_ + 1)
  private val uppercases: List[Int] = List.iterate(65, 26)(_ + 1)

  private def rot(n: Int, list: List[Int]): Map[Int, Char] = list.map {
    x => val y = x + n
      if (y > list.last) (x, (y - 26).toChar) else (x, y.toChar)
  }.toMap

  def rotate(input: String, n: Int): String = {
    val map = rot(n, lowercases) ++ rot(n, uppercases)
    input.map(x => map.getOrElse(x, x)).mkString
  }
}
