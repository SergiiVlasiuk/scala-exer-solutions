object MatchingBrackets5 {
  private val left = "{[("
  private val right = "}])"
  private val dict = (right zip left).toMap

  def isPaired(input: String) = {

    input.foldLeft(List[Char]('S'))((li, char) => char match {
      case c if left.contains(c) => c :: li
      case c if right.contains(c) =>
        if (li.head == dict(c)) li.tail
        else 'X' :: li
      case _ => li
    }) == List('S')
  }
}