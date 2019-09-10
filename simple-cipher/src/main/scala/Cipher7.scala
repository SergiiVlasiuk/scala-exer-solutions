case class Cipher7(op: Option[String]) {
  val key: String = op match {
    case None => "aaaaaaaaaa"
    case Some(a) =>
      if (a.isEmpty || a == a.toUpperCase) throw new IllegalArgumentException()
      else a
  }

  def loop(seq: Seq[(Char, Char)])(f: (Int, Int) => Int): String = {
    seq match {
      case Seq() => ""
      case (v, k) +: t => (Math.floorMod(f(v - 'a', k - 'a'), 26) + 'a').toChar + loop(t)(f)
    }
  }

  def decode(value: String): String = {
    loop(value.zip(key))((v, k) => v - k)
  }

  def encode(value: String): String = {
    loop(value.zip(key))((v, k) => v + k)
  }
}
