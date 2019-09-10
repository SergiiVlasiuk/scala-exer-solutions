object ProteinTranslation {
  def proteins(input: String): Seq[String] = {
    def decryptCodon(codon: String): String = {
      codon match {
        case "AUG" => "Methionine"
        case "UUU" | "UUC" => "Phenylalanine"
        case "UUA" | "UUG" => "Leucine"
        case "UCU" | "UCC" | "UCA" | "UCG" => "Serine"
        case "UAU" | "UAC" => "Tyrosine"
        case "UGU" | "UGC" => "Cysteine"
        case "UGG" => "Tryptophan"
        case "UAA" | "UAG" | "UGA" => "STOP"
      }
    }

    input.grouped(3).map(decryptCodon).takeWhile(_ != "STOP").toSeq
  }

}
