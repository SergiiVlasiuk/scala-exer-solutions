object RailFenceCipher8 {
  def encode(str: String, railCnt: Int): String = {
    val newIndices = makeNewIndices(str.length, railCnt)
    val indicesMap = newIndices.zipWithIndex.toMap

    transform(str, indicesMap)
  }

  def decode(str: String, railCnt: Int): String = {
    val indices = makeNewIndices(str.length, railCnt)
    val indicesMap = indices.zipWithIndex
      .map{ case (idx, newIdx) => (newIdx, idx) }
      .toMap

    transform(str, indicesMap)
  }

  private def transform(str: String, indicesMap: Map[Int, Int]): String = {
    str.zipWithIndex
      .map{ case (c, i) => (c, indicesMap(i)) }
      .sortWith(_._2 < _._2)
      .map{ case (c, i) => c }
      .mkString
  }

  // if railCnt = 5  =>  1 2 3 4 5 4 3 2 1 2 3 4 5 4...
  private def makeRailIndices(railCnt: Int): Stream[Int] = {
    val seq = (1 to railCnt) ++ (railCnt-1 to 2 by -1)
    Stream.continually(seq.toStream).flatten
  }

  private def makeNewIndices(length: Int, railCnt: Int): Seq[Int] = {
    makeRailIndices(railCnt).take(length)
      .zipWithIndex
      .groupBy{ case (railNo, index) => railNo }
      .mapValues{ list => list.map(_._2) }
      .toSeq
      .sortWith(_._1 < _._1)
      .map{ case (railNo, seq) => seq }
      .flatten
  }
}