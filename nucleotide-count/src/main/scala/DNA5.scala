class DNA5(strand: String) {
  import DNA5._

  require(strand forall List('A', 'T', 'C', 'G').contains)
  val strandMap = strand.groupBy(identity).mapValues(_.length)

  def nucleotideCounts: Map[Char, Int] = {
    nucMap ++ strandMap
  }
}

object DNA5 {
  val nucMap = Map('A' -> 0, 'T' -> 0, 'C' -> 0, 'G' -> 0)
}