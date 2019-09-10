import Sgf2._
import org.scalatest.{FunSuite, Matchers}

/** @version created manually **/
class Sgf2Test extends FunSuite with Matchers {
  test("parse \"\"") {
    Sgf2.parseSgf("") should be(None)
  }

  test("parse \"()\"") {
    Sgf2.parseSgf("()") should be(None)
  }

  test("parse \";\"") {
    Sgf2.parseSgf(";") should be(None)
  }

  test("parse \"(;)\"") {
    Sgf2.parseSgf("(;)") should be(Some(Node(Map())))
  }

  test("parse \"(;A[B])\"") {
    Sgf2.parseSgf("(;A[B])") should be(Some(Node(Map("A" -> List("B")))))
  }

  test("parse \"(;a)\"") {
    Sgf2.parseSgf("(;a)") should be(None)
  }

  test("parse \"(;a[b])\"") {
    Sgf2.parseSgf("(;a[b])") should be(None)
  }

  test("parse \"(;Aa[b])\"") {
    Sgf2.parseSgf("(;Aa[b])") should be(None)
  }

  test("parse \"(;A[B];B[C])\"") {
    Sgf2.parseSgf("(;A[B];B[C])") should be(
      Some(Node(Map("A" -> List("B")), List(Node(Map("B" -> List("C")))))))
  }

  test("parse \"(;A[B](;B[C])(;C[D]))\"") {
    Sgf2.parseSgf("(;A[B](;B[C])(;C[D]))") should be(
      Some(Node(Map("A" -> List("B")), List(Node(Map("B" -> List("C"))),
        Node(Map("C" -> List("D")))))))
  }

  test("parse \"(;A[b][c][d])\"") {
    Sgf2.parseSgf("(;A[b][c][d])") should be(Some(Node(Map("A" -> List("b", "c", "d")))))
  }

  test("""parse "(;A[\\]b\nc\\\nd\t\te\\\\ \\\n\\]])"""") {
    Sgf2.parseSgf("(;A[\\]b\nc\\\nd\t\te\\\\ \\\n\\]])") should be(
      Some(Node(Map("A" -> List("]b cd  e\\ ]")))))
  }
}
