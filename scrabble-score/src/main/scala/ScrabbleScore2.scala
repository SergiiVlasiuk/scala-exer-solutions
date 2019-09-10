object ScrabbleScore2 {

  def letterScores:Map[Char, Int] = List(
    ("AEIOULNRST", 1),
    ("DG", 2),
    ("BCMP", 3),
    ("FHVWY", 4),
    ("K", 5),
    ("JX", 8),
    ("QZ", 10)
  ).flatMap(e => e._1.map(c => (c, e._2))).toMap

  def score(s: String) = s.toUpperCase.map(letterScores.getOrElse(_, 0)).sum
}
