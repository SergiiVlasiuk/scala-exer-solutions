import scala.annotation.tailrec

object CollatzConjecture {
  // original https://exercism.io/tracks/scala/exercises/collatz-conjecture/solutions/ff0ade1ae7544b9c99bf1881164eccfc
  @tailrec
  def steps(number: Int, stepCount: Int = 0): Any =
    number match {
      case x if x < 1 => None
      case 1 => Some(stepCount)
      case x if x % 2 == 0 => steps(x / 2, stepCount + 1)
      case x => steps(3 * x + 1, stepCount + 1)
    }
}



// original https://exercism.io/tracks/scala/exercises/collatz-conjecture/solutions/8fc23cfec5684080b5abe04df2e41400
//object CollatzConjecture {
//  def steps(n: Int): Option[Int] = {
//    loop(n, 0)
//  }
//
//  @tailrec
//  private def loop(n: Int, count: Int): Option[Int] = n match {
//    case 1 => Some(count)
//    case NonPositive(_) => None
//    case Even(_) => loop(n / 2, count + 1)
//    case Odd(_) => loop(3 * n + 1, count + 1)
//  }
//}
//
//object Even {
//  def unapply(n: Int) = {
//    if (n % 2 == 0) Some(n) else None
//  }
//}
//
//object Odd {
//  def unapply(n: Int) = {
//    if (n % 2 == 1) Some(n) else None
//  }
//}
//
//object NonPositive {
//  def unapply(n: Int) = {
//    if (n < 1) Some(n) else None
//  }
//}


// my original first solution
//object CollatzConjecture {
//  def steps(num: Int): Option[Int] = {
//    def count(p: Int): Int = p match {
//      case 0 => 0
//      case 1 => 0
//      case `p` => 1 + count(next(p))
//    }
//
//    def next(p: Int): Int = p % 2 match {
//      case 1 =>
//        println(s"0 $p")
//        p * 3 + 1
//      case 0 =>
//        println(s"0 $p")
//        p / 2
//    }
//
//    num > 0 match {
//      case false => None
//      case true => Some(count(num))
//    }
//  }
//}
