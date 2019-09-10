import scala.util.parsing.combinator.RegexParsers

object Sgf2 extends RegexParsers {
  type Tree[A] = Node[A] // to separate the type from the constructor, cf. Haskell's Data.Tree
  type Forest[A] = List[Tree[A]]
  // A tree of nodes.
  type SgfTree = Tree[SgfNode]
  // A node is a property list, each key can only occur once.
  // Keys may have multiple values associated with them.
  type SgfNode = Map[String, List[String]]

  case class Node[A](rootLabel: A, subForest: Forest[A] = List())

  val values: Parser[List[String]] = rep1("[" ~ """((\\\])|[\s\w\\])+""".r ~ "]") ^^ {
    list =>
      list.map { case _ ~ value ~ _ => value
        .replaceAll("""\\\n""", "")
        .replaceAll("[\n\t]", " ")
        .replaceAll("""(\\\\)""", """\\""")
        .replaceAll("""(\\\])""", """]""")
      }
  }
  val element: Parser[SgfTree] = ";" ~ """[A-Z]+""".r ~ values ^^ {
    case _ ~ name ~ vals => Node[SgfNode](Map(name -> vals))
  }
  val empty: Parser[SgfTree] = ";" ^^ { _ => Node[SgfNode](Map.empty) }
  val blocks: Parser[SgfTree] = "(" ~ rep1(element | empty | blocks) ~ ")" ^^ {
    case (_ ~ root ~ _) => Node[SgfNode](root.head.rootLabel, root.head.subForest ++ root.tail)
  }

  def parseSgf(text: String): Option[SgfTree] = parseAll(blocks, text) match {
    case Success(result, _) => Some(result)
    case e: NoSuccess => println(e.msg + "\n" + e.next.pos); None
  }
}
