object RotationalCipher4 {
  private lazy val upperLimit = 'z'.toInt
  private lazy val offset = upperLimit - 'a'.toInt + 1

  def rotate(s: String, rots: Int): String = s.map(c => if (c.isLetter) rotate(c, rots) else c)

  private def rotate(c: Char, i: Int) =
    if (c.isUpper) rotateLower(c.toLower, i).toUpper else rotateLower(c, i)

  private def rotateLower(c: Char, i: Int) =
    if (c + i > upperLimit) (c + i - offset).toChar else (c + i).toChar
}
