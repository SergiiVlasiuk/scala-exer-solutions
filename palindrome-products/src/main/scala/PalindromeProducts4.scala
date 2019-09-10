import scala.annotation.tailrec

class PalindromeProducts4(val start: Int, val end: Int) {
  private def isPalindrome(candidate: Int): Boolean = {
    @tailrec
    def reverseNum(n: Int, newNum: Int): Int = n match {
      case 0 => newNum
      case x => reverseNum(x / 10, newNum * 10 + x % 10)
    }

    candidate == reverseNum(candidate, 0)
  }

  private lazy val palindromes = for {
    i <- start to end
    j <- i to end
    if isPalindrome(i * j)
  } yield (i * j, (i, j))

  private def get(find: (Int, Int) => Int): Option[(Int, Set[(Int, Int)])] = for {
    palindrome <- palindromes.map(_._1).reduceOption(find(_, _))
    products = palindromes.filter(_._1 == palindrome).map(_._2).toSet
  } yield (palindrome, products)

  lazy val smallest: Option[(Int, Set[(Int, Int)])] = get(math.min)
  lazy val largest: Option[(Int, Set[(Int, Int)])] = get(math.max)
}

object PalindromeProducts4 {
  def apply(start: Int, end: Int): PalindromeProducts4 = new PalindromeProducts4(start, end)
}
