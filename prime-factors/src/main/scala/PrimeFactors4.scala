import scala.annotation.tailrec

object PrimeFactors4 {
  def factors(n: Long): List[Long] = {
    @tailrec
    def fact(acc: List[Long], n: Long, candidate: Long): List[Long] = n match {
      case _ if n < 2 => acc
      case _ if n % candidate == 0 => fact(acc :+ candidate, n / candidate, candidate)
      case _ => fact(acc, n, candidate + 1)
    }

    fact(List(), n, 2)
  }
}
