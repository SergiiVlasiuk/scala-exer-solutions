import scala.annotation.tailrec
import scala.util.Try

class PalindromeProducts3(lower: Int, upper: Int) {

  def isPalindrome(n: Int): Boolean = {
    @tailrec
    def reverse10(n: Int, acc:Int = 0): Int =
      if( n <= 0 ) acc
      else reverse10(n / 10, acc * 10 + n % 10)

    n == reverse10(n)
  }

  lazy val palinProducts: Map[Int, Set[(Int, Int)]] =
    (for{
      i <- (lower to upper).toSet[Int]
      j <- i to upper
      if isPalindrome(i * j)
    } yield (i, j))
      .groupBy(x=> x._1 * x._2)


  lazy val smallest: Option[(Int, Set[(Int, Int)])] = Try(palinProducts.minBy(_._1)).toOption

  lazy val largest: Option[(Int, Set[(Int, Int)])] = Try(palinProducts.maxBy(_._1)).toOption
}

object PalindromeProducts3 {
  def apply(start: Int, end: Int): PalindromeProducts3 = new PalindromeProducts3(start, end)
}
