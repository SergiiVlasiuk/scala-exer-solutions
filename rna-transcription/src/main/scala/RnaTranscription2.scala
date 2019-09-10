object RnaTranscription2 {
  val rnaMap = Map('C' -> 'G', 'G' -> 'C', 'A' -> 'U', 'T' -> 'A')

  def toRna(dna: String): Option[String] = Some(dna.map(rnaMap.getOrElse(_, "")).mkString)
}
