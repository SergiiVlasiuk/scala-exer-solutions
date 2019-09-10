case class DNA2(dna: String) {

  val nucleotides: Set[Char] = Set[Char]('A', 'C', 'G', 'T')

  def nucleotideCounts: Either[String, Map[Char, Int]] =
    if (!dna.forall(nucleotides.contains)) Left("Error")
    else Right(nucleotides.foldLeft(Map[Char, Int]())((acc, nucl) => acc + (nucl -> dna.count(nucl ==))))
}