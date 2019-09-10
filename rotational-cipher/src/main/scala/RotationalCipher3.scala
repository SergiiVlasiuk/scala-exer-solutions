object RotationalCipher3 {
  private lazy val alphabet = 'a' to 'z'

  def rotate(clearText: String, rot: Int): String = {
    def rotateChar(c: Char) = alphabet((alphabet.indexOf(c) + rot) % alphabet.length)

    clearText.foldLeft(Seq.empty[Char]) { (a, c) =>
      c match {
        case upper if c.isUpper => a :+ rotateChar(upper.toLower).toUpper
        case lower if c.isLower => a :+ rotateChar(lower).toLower
        case nonLetter => a :+ nonLetter
      }
    }.mkString
  }
}
