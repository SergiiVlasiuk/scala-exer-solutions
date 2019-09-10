object Frequency3 {
  def frequency(n: Int, phrases: Seq[String]): Map[Char,Int] = {
    val res = collection.mutable.Map[Char, Int]()
    phrases.par.foreach { phrase =>
      val phr = phrase.filter(_.isLetter).toLowerCase
      phr.foreach { ch =>
        synchronized {
          res(ch) = res.getOrElseUpdate(ch, 0) + 1
        }
      }
    }
    res.toMap
  }
}
