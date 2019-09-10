import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class ScrabbleScore3Test extends FunSuite with Matchers {

  test("lowercase letter") {
    ScrabbleScore3.score("a") should be(1)
  }

  test("uppercase letter") {
    ScrabbleScore3.score("A") should be(1)
  }

  test("valuable letter") {
    ScrabbleScore3.score("f") should be(4)
  }

  test("short word") {
    ScrabbleScore3.score("at") should be(2)
  }

  test("short, valuable word") {
    ScrabbleScore3.score("zoo") should be(12)
  }

  test("medium word") {
    ScrabbleScore3.score("street") should be(6)
  }

  test("medium, valuable word") {
    ScrabbleScore3.score("quirky") should be(22)
  }

  test("long, mixed-case word") {
    ScrabbleScore3.score("OxyphenButazone") should be(41)
  }

  test("english-like word") {
    ScrabbleScore3.score("pinata") should be(8)
  }

  test("empty input") {
    ScrabbleScore3.score("") should be(0)
  }

  test("entire alphabet available") {
    ScrabbleScore3.score("abcdefghijklmnopqrstuvwxyz") should be(87)
  }
}
