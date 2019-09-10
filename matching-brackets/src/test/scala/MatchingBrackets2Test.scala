import org.scalatest.{FunSuite, Matchers}

/** @version 1.3.0 */
class MatchingBrackets2Test extends FunSuite with Matchers {

  test("paired square brackets") {
    MatchingBrackets2.isPaired("[]") should be(true)
  }

  test("empty string") {
    MatchingBrackets2.isPaired("") should be(true)
  }

  test("unpaired brackets") {
    MatchingBrackets2.isPaired("[[") should be(false)
  }

  test("wrong ordered brackets") {
    MatchingBrackets2.isPaired("}{") should be(false)
  }

  test("wrong closing bracket") {
    MatchingBrackets2.isPaired("{]") should be(false)
  }

  test("paired with whitespace") {
    MatchingBrackets2.isPaired("{ }") should be(true)
  }

  test("partially paired brackets") {
    MatchingBrackets2.isPaired("{[])") should be(false)
  }

  test("simple nested brackets") {
    MatchingBrackets2.isPaired("{[]}") should be(true)
  }

  test("several paired brackets") {
    MatchingBrackets2.isPaired("{}[]") should be(true)
  }

  test("paired and nested brackets") {
    MatchingBrackets2.isPaired("([{}({}[])])") should be(true)
  }

  test("unopened closing brackets") {
    MatchingBrackets2.isPaired("{[)][]}") should be(false)
  }

  test("unpaired and nested brackets") {
    MatchingBrackets2.isPaired("([{])") should be(false)
  }

  test("paired and wrong nested brackets") {
    MatchingBrackets2.isPaired("[({]})") should be(false)
  }

  test("math expression") {
    MatchingBrackets2.isPaired("(((185 + 223.85) * 15) - 543)/2") should be(true)
  }

  test("complex latex expression") {
    MatchingBrackets2.isPaired(
      """\left(\begin{array}{cc} \frac{1}{3} & x\ \mathrm{e}^{x} &... x^2 \end{array}\right)""") should be(
      true)
  }
}
