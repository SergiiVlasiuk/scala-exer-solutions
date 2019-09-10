

object SumOfMultiples {

  def sum(factors: Set[Int], limit: Int): Int =
    factors flatMap(f => f until limit by f) sum
//  (for {factor <- factors
//        factor <- factor until limit by factor
//  } yield factor).sum

}

