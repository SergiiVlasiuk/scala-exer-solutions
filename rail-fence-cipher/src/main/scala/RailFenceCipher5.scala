object RailFenceCipher5 {

  def rails(n: Int): Stream[Int] = {
    val xs = (1 to n).toList
    val ys = xs ++ xs.reverse.tail.init
    Stream.continually(ys.toStream).flatten
  }

  def encode(s: String, n: Int): String = {
    val t = s.toCharArray filter (_.isLetter)
    val u = t zip rails(n)
    val f = (m: Int) => u filter (_._2 == m)
    ((1 to n).toList map f).flatten.map(_._1).mkString
  }

  def decode(s: String, n: Int): String = {
    val rs = rails(n) take s.length
    val t = (s zip rs.sorted).groupBy(_._2).toSeq.sortBy(_._1).map(_._2).map(_.map(_._1))
    val xs = rs.foldLeft(("", t))((t, rail) => {
      val acc = t._2(rail - 1).head + t._1
      val xss = ((1 to n).toList zip t._2) map {
        case u if u._1 == rail => u._2.tail
        case u                 => u._2
      }
      (acc, xss)
    })
    xs._1.reverse
  }
}