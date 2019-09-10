class DNA6(strand: String){
  if (strand.exists(x => !"ATCG".contains(x))) throw new RuntimeException
  def nucleotideCounts: Map[Char, Int] = strand.foldLeft(Map('A'-> 0, 'T' -> 0, 'C' -> 0, 'G' -> 0))((ms,c) => ms + (c -> (1 + (ms(c)))))
}

