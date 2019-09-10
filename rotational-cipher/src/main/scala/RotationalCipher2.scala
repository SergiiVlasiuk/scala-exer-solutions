object RotationalCipher2 {
  private lazy val lower = ('a' to 'z').toList
  private lazy val upper = ('A' to 'Z').toList

  def translate(c: Char, l: List[Char], key: Int): Char = if (l.contains(c)) l((l.indexOf(c) + key) % 26) else c

  def rotate(text: String, key: Int): String = text.map(l => translate(l, lower, key)).map(l => translate(l, upper, key))
}
