object RailFenceCipher4 {

  def encode(input: String, numberRows: Int): String =
    encodeInts(input.length, numberRows).map(input.charAt).mkString

  def decode(input: String, numberRows: Int): String =
    encodeInts(input.length,numberRows).zip(input).sortBy(_._1).map(_._2).mkString

  private def encodeInts(max: Int, numberRows: Int): List[Int] = {
    val buffer = scala.collection.mutable.ListBuffer.fill(numberRows)(List[Int]())
    var line = 0
    var delta = -1
    (0 until max).foreach{
      i => buffer.update(line, buffer(line):+i)
        if (i % (numberRows-1) == 0) delta = -delta
        line += delta
    }
    buffer.toList.flatten
  }
}