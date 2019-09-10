case class DNA4(dna: String) {
  private val nucleotides = Set('A', 'C', 'G', 'T')

  def nucleotideCounts: Either[String, Map[Char, Int]] =
  //    nucleotides.toUpperCase.toList.groupBy(identity).mapValues(_.size) match {
    dna.toUpperCase.toList match {
      case check if (check.exists(x => !nucleotides.contains(x))) => Left(s"Unknown nucleotide!")
      case x => Right(x.foldLeft(nucleotides.map(x => x -> 0).toMap) { case (m, c) => m.updated(c, m(c) + 1) })
    }
}