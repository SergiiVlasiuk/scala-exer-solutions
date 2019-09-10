case class DNA3(strand: String) {
  type Nucleotides = Map[Char, Int]

  private lazy val nucleotides = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)

  val nucleotideCounts: Either[Boolean, Nucleotides] = {
    if (strand.forall(nucleotides.keySet.contains)) Right(nucleotides ++ strand.groupBy(identity).mapValues(_.size))
    else Left(false)
  }

  private def isNucleotide(c: Char): Boolean = "ACGT".contains(c)
}