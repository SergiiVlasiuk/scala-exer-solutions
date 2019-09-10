import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class ScrabbleScore2Test extends FunSuite with Matchers {

  test("lowercase letter") {
    ScrabbleScore2.score("a") should be(1)
  }

  test("uppercase letter") {
    ScrabbleScore2.score("A") should be(1)
  }

  test("valuable letter") {
    ScrabbleScore2.score("f") should be(4)
  }

  test("short word") {
    ScrabbleScore2.score("at") should be(2)
  }

  test("short, valuable word") {
    ScrabbleScore2.score("zoo") should be(12)
  }

  test("medium word") {
    ScrabbleScore2.score("street") should be(6)
  }

  test("medium, valuable word") {
    ScrabbleScore2.score("quirky") should be(22)
  }

  test("long, mixed-case word") {
    ScrabbleScore2.score("OxyphenButazone") should be(41)
  }

  test("english-like word") {
    ScrabbleScore2.score("pinata") should be(8)
  }

  test("empty input") {
    ScrabbleScore2.score("") should be(0)
  }

  test("entire alphabet available") {
    ScrabbleScore2.score("abcdefghijklmnopqrstuvwxyz") should be(87)
  }
}
