object Dominoes5 {
  def chain(input: List[(Int, Int)]): Option[List[(Int, Int)]] = {
    def loop(residue: List[(Int, Int)], actuals: List[List[(Int, Int)]]): List[List[(Int, Int)]] = {
      residue match {
        case Nil => actuals
        case r => r.flatMap { x =>
          val rest = r.span(_ != x) match {
            case (a, b) => a ::: b.tail
          }
          val newCandidates = actuals.flatMap(l => makeCandidate(l, x))
          loop(rest, newCandidates)
        }
      }
    }

    input match {
      case Nil => Some(Nil)
      case (a, b) :: Nil => if (a == b) Some(input) else None
      case head :: tail => val resultsTmp = loop(tail, List(List(head)))
        resultsTmp.filter(_.size == input.size).find(l => checkPair(l.last, l.head))
    }
  }

  private def makeCandidate(candidates: List[(Int, Int)], ab: (Int, Int)): List[List[(Int, Int)]] = {
    val ba = swap(ab)
    ((ab :: candidates) :: (ba :: candidates) :: (candidates :+ ab) :: (candidates :+ ba) :: Nil)
      .filter { l => checkPair(l.head, l.tail.head) && checkPair(l.init.last, l.last) }
  }

  private def checkPair(a: (Int, Int), b: (Int, Int)): Boolean = a._2 == b._1

  private def swap(ab: (Int, Int)): (Int, Int) = ab.swap
}
