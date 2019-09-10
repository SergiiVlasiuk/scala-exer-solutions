object ScrabbleScore {
  def scoreLetter: (Char) => Int = _ match {
    case 'A' | 'E' | 'I' | 'O' | 'U' | 'L' | 'N' | 'R' | 'S' | 'T' => 1
    case 'D' | 'G' => 2
    case 'B' | 'C' | 'M' | 'P' => 3
    case 'F' | 'H' | 'V' | 'W' | 'Y' => 4
    case 'K' => 5
    case 'J' | 'X' => 8
    case 'Q' | 'Z' => 10
    case _ => 0
  }

  def score(word: String) = word.toUpperCase.map(scoreLetter).sum
}
