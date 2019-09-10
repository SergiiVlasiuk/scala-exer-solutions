object RnaTranscription3 {
  def toRna(strand: String): Option[String] = {
    Some(strand.toList.flatMap(x => convert(x)).mkString(""))
  }

  def convert(nucleotide: Char): Option[Char] = nucleotide match {
    case 'C' => Some('G')
    case 'G' => Some('C')
    case 'T' => Some('A')
    case 'A' => Some('U')
    case _ => None
  }
}