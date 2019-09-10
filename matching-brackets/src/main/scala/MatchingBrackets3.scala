object MatchingBrackets3 {

  def isPaired(str: String): Boolean = {
    def loop(s: List[Char], stack: List[Char], valid: Boolean): Boolean = {
      s match {
        case (c@('(' | '[' | '{')) :: rest => loop(rest, closing(c) :: stack, valid)
        case (c@(')' | ']' | '}')) :: rest => if (stack.isEmpty) false else loop(rest, stack.tail, stack.head == c)
        case _ :: rest => loop(rest, stack, valid)
        case _ if !valid => false
        case Nil => stack.isEmpty
      }
    }

    def closing(c: Char): Char = c match {
      case '(' => ')'
      case '[' => ']'
      case '{' => '}'
    }

    loop(str.toList, Nil, true)
  }

}