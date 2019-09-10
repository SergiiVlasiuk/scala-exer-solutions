import scala.annotation.tailrec

case object Alphametics2 {
  def solve(str: String): Option[Map[Char, Int]] = {
    val Array(lhs, sum) = str.split(" == ")
    val summands = lhs.split(" \\+ ")
    val letters = str.filter(_.isLetter).toCharArray.toSet.toIndexedSeq
    val leadingLetters = letters.filter((c) => c == sum.charAt(0) || summands.exists(_.charAt(0) == c))

    @tailrec
    def selectGood(permutations: Stream[Stream[Int]], acc: List[Map[Char, Int]]): List[Map[Char, Int]] = {
      if (permutations.isEmpty) acc
      else {
        val p = permutations.head
        val m = letters.zip(p).toMap
        if (!leadingLetters.exists(m.getOrElse(_, -1) == 0) &&
          tokenToNumber(sum, m) == summands.map((summand) => tokenToNumber(summand, m)).sum)
          selectGood(permutations.tail, m :: acc)
        else selectGood(permutations.tail, acc)
      }
    }

    selectGood(permutations((0 to 9).toStream, letters.size), List()) match {
      case List(m) => Some(m)
      case _ => None
    }
  }
  private def tokenToNumber(str: String, m: Map[Char, Int]): Long = {
    str.map(m.getOrElse(_,0).toString).reduce(_+_).toLong
  }
  private def permutations(seq: Stream[Int], length: Int): Stream[Stream[Int]] = {
    if (length <= 1) seq.map(Seq(_).toStream) else
      for {
        h <- seq
        tailPerm <- permutations(seq.filter(_ != h), length - 1)
      } yield h #:: tailPerm
  }
}