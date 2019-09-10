import scala.annotation.tailrec

object MatchingBrackets2 {

  @tailrec
  def loop(brackets: String): Boolean = {
    val reduced = brackets.replace("{}", "").replace("[]", "").replace("()", "")
    if (reduced.isEmpty) true
    else if (reduced == brackets) false
    else loop(reduced)
  }

  def isPaired(str: String): Boolean = {
    if (str.isEmpty) true
    else loop(str.filter("{}[]()".contains(_)))
  }
}