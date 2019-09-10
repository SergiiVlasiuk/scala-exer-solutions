import scala.annotation.tailrec

object Alphametics3 {

  private val digits = Stream.iterate(0, 10)(_ + 1)

  /**
    * injections from {1,2,...,p} to {1, 2, ... n}, n >= p
    */
  private def generateInjections(p: Int, f: Stream[Int]): Stream[List[Int]] =
    if (p == 1)
      f.map(List(_))
    else {
      for {
        x <- f
        newF = f.filter(_ != x)
        pgi = generateInjections(p - 1, newF)
        a <- pgi
      } yield x :: a
    }

  def solve(expression: String): Option[Map[Char, Int]] = {
    val letters = expression.filter(_.isLetter).toSet
    val (terms, result) = {
      val expr01 = expression.split(" == ")
      (expr01(0).split(" \\+ ").toList, expr01(1))
    }
    val firstChars = {
      val r = result.charAt(0) :: terms.map(_.charAt(0))
      r.toSet
    }

    def isSolution(candidate: Map[Char, Int]): Boolean = {
      val sum = terms.map(s => s.foldLeft("")((acc, c) => acc + candidate(c))).map(_.toLong).sum
      val r = result.foldLeft("")((acc, c) => acc + candidate(c)).toLong
      sum == r
    }

    @tailrec
    def loop(mp: Stream[Map[Char, Int]]): Option[Map[Char, Int]] = mp match {
      case Stream() => None
      case h #:: tail => if (isSolution(h)) Some(h) else loop(tail)
    }

    loop {
      generateInjections(letters.size, digits).map(letters.toStream.zip(_))
        .map(_.toMap)
        .filter(x => firstChars.forall(x(_) != 0))
    }.map(m => Map(m.toSeq.sortBy(_._1): _*))
  }
}
