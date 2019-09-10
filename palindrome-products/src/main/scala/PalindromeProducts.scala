import PalindromeProducts._

import scala.util.Try

case class PalindromeProducts(start: Int, end: Int) {
  private lazy val factoredPairsProduct: Map[Int, Set[(Int, Int)]] = (for {
    i <- (start to end).toSet[Int]
    j <- i to end if isPalindrome(i * j)
  } yield (i, j)) groupBy (x => x._1 * x._2)
  lazy val smallest = Try(factoredPairsProduct.minBy(_._1)).toOption
  lazy val largest = Try(factoredPairsProduct.maxBy(_._1)).toOption
}

object PalindromeProducts {
  def isPalindrome(num: Int): Boolean = {
    num == reverse(num)
  }

  def reverse(n: Int, f: Int = 0): Int = n match {
    case 0 => f
    case _ => reverse(n / 10, f * 10 + n % 10)
  }
}
