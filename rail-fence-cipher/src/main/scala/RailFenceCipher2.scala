import scala.collection.mutable.ListBuffer

object RailFenceCipher2 {
  type Rails = ListBuffer[List[(Int, Char)]]

  def encode(text: String, depth: Int): String = {
    collect(text, depth)
      .flatten
      .map { case (i, c) => c }
      .mkString
  }

  def decode(text: String, depth: Int): String = {
    val indexes = collect(text, depth)
      .flatten
      .map { case (i, c) => i }

    (0 until text.length)
      .foldLeft("")((acc, i) =>
        acc + text(indexes.indexOf(i)))
  }

  def collect(ts: String, depth: Int): Rails = {
    val empty = ListBuffer.fill(depth)(List[(Int, Char)]())
    ts.foldLeft((0, 0, 0, empty))((acc, a) => {
      val (line, inc, index, z)  = acc
      val ninc =
        if (line == 0) 1
        else if (line == (depth - 1)) - 1
        else inc
      z(line) = z(line) :+ (index, a)
      (line + ninc, ninc, index + 1, z)
    })._4
  }
}