object RotationalCipher {
  private val lowStart: Int = 'a'.toInt
  private val lowEnd: Int = 'z'.toInt
  private val upperStart: Int = 'A'.toInt
  private val upperEnd: Int = 'Z'.toInt

  def rotate(in: String, key: Int): String = in.map({
    case x if upperStart <= x && x <= upperEnd => (((x - upperStart) + key) % 26 + upperStart).toChar
    case x if lowStart <= x && x <= lowEnd => (((x - lowStart) + key) % 26 + lowStart).toChar
    case x => x
  }).mkString
}
