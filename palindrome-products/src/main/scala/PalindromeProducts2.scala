import PalindromeProducts2._

import scala.util.Try

case class PalindromeProducts2(start: Int, end: Int) {
  val factoredPairs: Seq[(Int, Int)] = for {
    i <- start to end
    j <- i to end if isPalindrome(i * j)
  } yield (i, j)

  val factoredPairsProduct: Map[Int, Set[(Int, Int)]] = {
    factoredPairs.toSet.groupBy { case (x, y) => x * y } //(x => x._1 * x._2)
  }

  val smallest = Try(factoredPairsProduct.minBy(x => x._1)).toOption
  val largest = Try(factoredPairsProduct.maxBy(_._1)).toOption
}

object PalindromeProducts2 {
  def isPalindrome(num: Int): Boolean = {
    num == reverse(num)
  }

  def reverse(n: Int, f: Int = 0): Int = n match {
    case 0 => f
    case _ => reverse(n / 10, f * 10 + n % 10)
  }
}
