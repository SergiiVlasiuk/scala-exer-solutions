object Frequency {
  def frequency(numWorkers: Int, texts: Seq[String]): Map[Char, Int] = texts match {
    case Seq() => Map()
    case _ => texts.par.reduce(_ + _).filter(_.isLetter).toLowerCase
      .groupBy(identity).map(x => (x._1, x._2.length)).seq
  }
}
