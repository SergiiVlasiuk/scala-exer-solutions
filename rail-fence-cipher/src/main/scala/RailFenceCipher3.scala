object RailFenceCipher3 {
  def encode(text: String, rails: Int): String = {
    val builders = Array.fill(rails)(new StringBuilder())
    walk(text, text.length, rails) { case (r, char) => builders(r).append(char) }
    builders.foldLeft(new StringBuilder(text.length))(_.append(_)).toString()
  }

  def decode(text: String, rails: Int): String = {
    val grid = Array.fill(rails)(Seq.empty[Int])
    walk(0 until text.length, text.length, rails) { case (r, idx) => grid(r) = grid(r) :+ idx } //let's build the grid first
    val decoded = new StringBuilder(text.length, text)

    grid.foldLeft(text) { case (remaining, rail) =>
      val consume = remaining.take(rail.length)
      consume.zip(rail).foreach { case (char, idx) => decoded.update(idx, char)}
      remaining.drop(rail.length)
    }

    decoded.toString()
  }

  private def walk[T](collection: Seq[T], length: Int, rails: Int)(walker: (Int, T) => Unit): Unit = {
    collection.foldLeft((0, 1)) { case ((idx, offset), item) =>
      val nOffset = if ((idx + offset == rails) || (idx + offset < 0)) offset * -1 else offset
      walker(idx, item)
      (idx + nOffset, nOffset)
    }
  }
}
