object RailFenceCipher11 {
  def encode(toEncode: String, railCnt: Int): String = {
    val indicesMap = toEncode.zip(makeNewIndices(railCnt))
    indicesMap.sortBy(_._2).map(_._1).mkString
  }

  /*
    def decode(str: String, railCnt: Int): String = {
      val indexes = makeNewIndices(railCnt) take str.length
      val indicesMap = str zip indexes.sorted
      val tuples = indicesMap.groupBy(_._2).toSeq.sortBy(_._1)
      val seq = tuples.map(_._2).map(_.map(_._1))
      println(s"indicesMap: $indicesMap,\n\t tuples: $tuples\n\t\tseq: $seq")
  //    val indicesMap = indices.zipWithIndex
  //      .map { case (idx, newIdx) => (newIdx, idx) }
  //      .toMap

  //    transform(str, indicesMap)
      indicesMap.sortBy(_._2).map(_._1).mkString
  //    "any"
    }
  */
  def decode(toDecode: String, railCnt: Int): String = {
    val generatedIndexes = makeNewIndices(railCnt) take toDecode.length
    val t = (toDecode zip generatedIndexes.sorted).groupBy(_._2).toSeq.sortBy(_._1).map(_._2).map(_.map(_._1))
    println(s"(toDecode zip generatedIndexes.sorted):\n\t${(toDecode zip generatedIndexes.sorted)}")
    println(s"(toDecode zip generatedIndexes.sorted).groupBy(_._2):\n\t${(toDecode zip generatedIndexes.sorted).groupBy(_._2)}")
    println(s"(toDecode zip generatedIndexes.sorted).groupBy(_._2).toSeq.sortBy(_._1):\n\t${(toDecode zip generatedIndexes.sorted).groupBy(_._2).toSeq.sortBy(_._1)}")
    println(s"(toDecode zip generatedIndexes.sorted).groupBy(_._2).toSeq.sortBy(_._1).map(_._2):\n\t${(toDecode zip generatedIndexes.sorted).groupBy(_._2).toSeq.sortBy(_._1).map(_._2)}")
    println(s"(toDecode zip generatedIndexes.sorted).groupBy(_._2).toSeq.sortBy(_._1).map(_._2).map(_.map(_._1)):\n\t$t")
    val xs = generatedIndexes.foldLeft(("", t))((t, rail) => {
      val acc = t._2(rail - 1).head + t._1
      val xss = ((1 to railCnt).toList zip t._2) map {
        case u if u._1 == rail => u._2.tail
        case u                 => u._2
      }
      (acc, xss)
    })
    println(s"result: ${xs._1.reverse}\n")
    xs._1.reverse
  }

  def makeNewIndices(n: Int): Stream[Int] = {
    val xs = (1 to n).toList
    val ys = xs ++ xs.reverse.tail.init
    Stream.continually(ys.toStream).flatten
  }
}
