object Diamond5 {

  def rows(c: Char): List[String] = {

    def loop(a: Char, spaces: Int, midSpaces: Int, soFar: List[String]): List[String] = a match {
      case `c` => (c + " " * midSpaces + c) :: soFar
      case 'A' => loop((a + 1).toChar, spaces - 1, midSpaces + 1, (" " * spaces + a + " " * spaces) :: soFar)
      case _ => loop((a + 1).toChar, spaces - 1, midSpaces + 2, (" " * spaces + a + " " * midSpaces + a + " " * spaces) :: soFar)
    }

    c match {
      case 'A' => List("A")
      case _ => {
        val triangle = loop('A', c - 'A', 0, List())
        triangle.reverse ::: triangle.tail
      }
    }
  }
}