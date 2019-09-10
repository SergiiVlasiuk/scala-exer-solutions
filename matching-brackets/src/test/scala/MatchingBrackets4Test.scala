import org.scalatest.{FunSuite, Matchers}

/** @version 1.3.0 */
class MatchingBrackets4Test extends FunSuite with Matchers {

  test("paired square brackets") {
    MatchingBrackets4.isPaired("[]") should be(true)
  }

  test("empty string") {
    MatchingBrackets4.isPaired("") should be(true)
  }

  test("unpaired brackets") {
    MatchingBrackets4.isPaired("[[") should be(false)
  }

  test("wrong ordered brackets") {
    MatchingBrackets4.isPaired("}{") should be(false)
  }

  test("wrong closing bracket") {
    MatchingBrackets4.isPaired("{]") should be(false)
  }

  test("paired with whitespace") {
    MatchingBrackets4.isPaired("{ }") should be(true)
  }

  test("partially paired brackets") {
    MatchingBrackets4.isPaired("{[])") should be(false)
  }

  test("simple nested brackets") {
    MatchingBrackets4.isPaired("{[]}") should be(true)
  }

  test("several paired brackets") {
    MatchingBrackets4.isPaired("{}[]") should be(true)
  }

  test("paired and nested brackets") {
    MatchingBrackets4.isPaired("([{}({}[])])") should be(true)
  }

  test("unopened closing brackets") {
    MatchingBrackets4.isPaired("{[)][]}") should be(false)
  }

  test("unpaired and nested brackets") {
    MatchingBrackets4.isPaired("([{])") should be(false)
  }

  test("paired and wrong nested brackets") {
    MatchingBrackets4.isPaired("[({]})") should be(false)
  }

  test("math expression") {
    MatchingBrackets4.isPaired("(((185 + 223.85) * 15) - 543)/2") should be(true)
  }

  test("complex latex expression") {
    MatchingBrackets4.isPaired(
      """\left(\begin{array}{cc} \frac{1}{3} & x\ \mathrm{e}^{x} &... x^2 \end{array}\right)""") should be(
      true)
  }
}
