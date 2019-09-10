import scala.annotation.tailrec

object PrimeFactors2 {

  def factors(number: Long): List[Long] = {
    @tailrec
    def loop(candidate: Long, acc: List[Long], newNumber: Long): List[Long] = newNumber match {
      case 1 => acc.reverse
      case _ =>
        if (newNumber % candidate == 0) loop(candidate, candidate :: acc, newNumber / candidate)
        else loop(candidate + 1, acc, newNumber)
    }

    loop(2, Nil, number)
  }
}
