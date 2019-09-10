import scala.util.parsing.combinator.RegexParsers

object Sgf3 extends RegexParsers {

  type Tree[A] = Node[A]
  type Forest[A] = List[Tree[A]]

  case class Node[A](rootLabel: A, subForest: Forest[A] = List())

  type SgfTree = Tree[SgfNode]
  type SgfNode = Map[String, List[String]]

  private def node =
    '(' ~> rep1(nodeContent1 | nodeContent2) <~ ')' ^^ {
      nodes => Node(nodes.head.rootLabel, nodes.tail)
    }

  private def nodeContent1: Parser[SgfTree] =
    ';' ~> (name | empty) ~ attributes ^^ {
      case "" ~ _ => Node(Map[String, List[String]]())
      case name ~ attributes => Node(Map(name -> attributes))
    }

  private def nodeContent2: Parser[SgfTree] =
    """(;""" ~> (name | empty) ~ attributes <~ ')' ^^ {
      case "" ~ _ => Node(Map[String, List[String]]())
      case name ~ attributes => Node(Map(name -> attributes))
    }

  private def attributes: Parser[List[String]] = rep1(attr) | emptyAttributes

  private def emptyAttributes = "" ^^ (_ => List[String]())

  private def name = """[A-Z]""".r

  private def empty = ""

  private def attr = '[' ~> attrValue <~ ']' ^^ { c => c }

  private def attrValue = rep1(attrValuePart) ^^ { s => s.mkString }

  private def attrValuePart: Parser[String] =
    newline | tab | space | escapedNewline | escapedChar | ident

  val newline: Parser[String] = '\n' ^^ { _ => " " }
  val tab: Parser[String] = '\t' ^^ { _ => " " }
  val space: Parser[String] = ' ' ^^ { _ => " " }
  val escapedNewline: Parser[String] = """\\\n""".r ^^ { _ => "" }
  val escapedChar: Parser[String] = """\\.""".r ^^ { s => s.drop(1) }
  val ident: Parser[String] = "[^]]".r


  def parseSgf(text: String): Option[SgfTree] = parseAll(node, text) match {
    case Success(result, _) => Some(result)
    case NoSuccess(_, _) => None
  }
}
