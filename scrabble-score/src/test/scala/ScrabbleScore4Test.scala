import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class ScrabbleScore4Test extends FunSuite with Matchers {

  test("lowercase letter") {
    ScrabbleScore4.score("a") should be(1)
  }

  test("uppercase letter") {
    ScrabbleScore4.score("A") should be(1)
  }

  test("valuable letter") {
    ScrabbleScore4.score("f") should be(4)
  }

  test("short word") {
    ScrabbleScore4.score("at") should be(2)
  }

  test("short, valuable word") {
    ScrabbleScore4.score("zoo") should be(12)
  }

  test("medium word") {
    ScrabbleScore4.score("street") should be(6)
  }

  test("medium, valuable word") {
    ScrabbleScore4.score("quirky") should be(22)
  }

  test("long, mixed-case word") {
    ScrabbleScore4.score("OxyphenButazone") should be(41)
  }

  test("english-like word") {
    ScrabbleScore4.score("pinata") should be(8)
  }

  test("empty input") {
    ScrabbleScore4.score("") should be(0)
  }

  test("entire alphabet available") {
    ScrabbleScore4.score("abcdefghijklmnopqrstuvwxyz") should be(87)
  }
}
