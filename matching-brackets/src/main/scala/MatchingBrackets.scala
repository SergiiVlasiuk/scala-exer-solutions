object MatchingBrackets {
  def isPaired(payload: String): Boolean = {
    def go(brackets: List[Char], stack: List[Char]): Boolean =
      (brackets, stack) match {
        case (Nil, Nil) => true
        case (('{' | '[' | '(')::xs, _) => go(xs, brackets.head :: stack)
        case ('}'::xs, '{'::ys) => go(xs, ys)
        case (']'::xs, '['::ys) => go(xs, ys)
        case (')'::xs, '('::ys) => go(xs, ys)
        case _ => false
      }
//    println(payload.filter("(){}[]".toSet))
    go(payload.filter("(){}[]".toSet).toList, List())
  }
}
// Note: rdblyth's solution