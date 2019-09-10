import org.scalatest.{FunSuite, Matchers}

/** @version 1.3.0 */
class MatchingBrackets3Test extends FunSuite with Matchers {

  test("paired square brackets") {
    MatchingBrackets3.isPaired("[]") should be(true)
  }

  test("empty string") {
    MatchingBrackets3.isPaired("") should be(true)
  }

  test("unpaired brackets") {
    MatchingBrackets3.isPaired("[[") should be(false)
  }

  test("wrong ordered brackets") {
    MatchingBrackets3.isPaired("}{") should be(false)
  }

  test("wrong closing bracket") {
    MatchingBrackets3.isPaired("{]") should be(false)
  }

  test("paired with whitespace") {
    MatchingBrackets3.isPaired("{ }") should be(true)
  }

  test("partially paired brackets") {
    MatchingBrackets3.isPaired("{[])") should be(false)
  }

  test("simple nested brackets") {
    MatchingBrackets3.isPaired("{[]}") should be(true)
  }

  test("several paired brackets") {
    MatchingBrackets3.isPaired("{}[]") should be(true)
  }

  test("paired and nested brackets") {
    MatchingBrackets3.isPaired("([{}({}[])])") should be(true)
  }

  test("unopened closing brackets") {
    MatchingBrackets3.isPaired("{[)][]}") should be(false)
  }

  test("unpaired and nested brackets") {
    MatchingBrackets3.isPaired("([{])") should be(false)
  }

  test("paired and wrong nested brackets") {
    MatchingBrackets3.isPaired("[({]})") should be(false)
  }

  test("math expression") {
    MatchingBrackets3.isPaired("(((185 + 223.85) * 15) - 543)/2") should be(true)
  }

  test("complex latex expression") {
    MatchingBrackets3.isPaired(
      """\left(\begin{array}{cc} \frac{1}{3} & x\ \mathrm{e}^{x} &... x^2 \end{array}\right)""") should be(
      true)
  }
}
