import Sgf3._
import org.scalatest.{FunSuite, Matchers}

/** @version created manually **/
class Sgf3Test extends FunSuite with Matchers {
  test("parse \"\"") {
    Sgf3.parseSgf("") should be(None)
  }

  test("parse \"()\"") {
    Sgf3.parseSgf("()") should be(None)
  }

  test("parse \";\"") {
    Sgf3.parseSgf(";") should be(None)
  }

  test("parse \"(;)\"") {
    Sgf3.parseSgf("(;)") should be(Some(Node(Map())))
  }

  test("parse \"(;A[B])\"") {
    Sgf3.parseSgf("(;A[B])") should be(Some(Node(Map("A" -> List("B")))))
  }

  test("parse \"(;a)\"") {
    Sgf3.parseSgf("(;a)") should be(None)
  }

  test("parse \"(;a[b])\"") {
    Sgf3.parseSgf("(;a[b])") should be(None)
  }

  test("parse \"(;Aa[b])\"") {
    Sgf3.parseSgf("(;Aa[b])") should be(None)
  }

  test("parse \"(;A[B];B[C])\"") {
    Sgf3.parseSgf("(;A[B];B[C])") should be(
      Some(Node(Map("A" -> List("B")), List(Node(Map("B" -> List("C")))))))
  }

  test("parse \"(;A[B](;B[C])(;C[D]))\"") {
    Sgf3.parseSgf("(;A[B](;B[C])(;C[D]))") should be(
      Some(Node(Map("A" -> List("B")), List(Node(Map("B" -> List("C"))),
        Node(Map("C" -> List("D")))))))
  }

  test("parse \"(;A[b][c][d])\"") {
    Sgf3.parseSgf("(;A[b][c][d])") should be(Some(Node(Map("A" -> List("b", "c", "d")))))
  }

  test("""parse "(;A[\\]b\nc\\\nd\t\te\\\\ \\\n\\]])"""") {
    Sgf3.parseSgf("(;A[\\]b\nc\\\nd\t\te\\\\ \\\n\\]])") should be(
      Some(Node(Map("A" -> List("]b cd  e\\ ]")))))
  }
}
