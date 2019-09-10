case class DNA(dna: String) {
  val dnaTypes: String = "ACGT"
  val dnaRegex = s"[^$dnaTypes]".r

  def nucleotideCounts: Either[String, Map[Char, Int]] =
    if (dnaRegex.findAllMatchIn(dna).hasNext) Left("Unknown nucleotide!")
    else Right(Map(dnaTypes.toCharArray.map(x => (x, dna.count(_ == x))).toSeq: _*))
}
