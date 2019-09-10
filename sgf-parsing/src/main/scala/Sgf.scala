import scala.util.parsing.combinator.RegexParsers

object Sgf extends RegexParsers {
  type Tree[A] = Node[A] // to separate the type from the constructor, cf. Haskell's Data.Tree
  type SgfTree = Tree[SgfNode]
  type SgfNode = Map[String, List[String]]
  // A node is a property list, each key can only occur once.
  // Keys may have multiple values associated with them.
  type Forest[A] = List[Tree[A]]

  case class Node[A](rootLabel: A, subForest: Forest[A] = List())

  override def skipWhitespace = false

  lazy val validProp: Parser[String] = "[A-Z]".r
  lazy val escapedChar = "\\" ~> ".".r
  lazy val escapedNewline = """\\\n""".r ^^^ ""
  lazy val whitespace: Parser[String] = """\s""".r ^^^ " "
  lazy val char: Parser[String] = "[^]]".r
  lazy val propertyValue = "[" ~> rep1(escapedNewline | whitespace | escapedChar | char) <~ "]" ^^ (_.mkString)
  lazy val property = validProp ~ rep(propertyValue) ^^ { case p ~ vs => Map(p -> vs) }
  lazy val node: Parser[SgfNode] = ";" ~> opt(property) ^^ (_.getOrElse(Map()))
  lazy val tree: Parser[SgfTree] = "(" ~> rep1(node) ~ rep(tree) <~ ")" ^^ { case nodes ~ trees =>
    nodes.headOption match {
      case Some(n) => Node(n, nodes.drop(1).map(n => Node(n)) ++ trees)
      case _ => Node(Map())
    }
  }

  def parseSgf(text: String): Option[SgfTree] = parse(tree, text) match {
    case Success(matched, _) => Option(matched)
    case _ => None
  }
}