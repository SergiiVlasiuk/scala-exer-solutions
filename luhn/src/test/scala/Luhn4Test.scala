import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class Luhn4Test extends FunSuite with Matchers {

  test("single digit strings can not be valid") {
    Luhn4.valid("1") should be(false)
  }

  test("a single zero is invalid") {
    Luhn4.valid("0") should be(false)
  }

  test("a simple valid SIN that remains valid if reversed") {
    Luhn4.valid("059") should be(true)
  }

  test("a simple valid SIN that becomes invalid if reversed") {
    Luhn4.valid("59") should be(true)
  }

  test("a valid Canadian SIN") {
    Luhn4.valid("055 444 285") should be(true)
  }

  test("invalid Canadian SIN") {
    Luhn4.valid("055 444 286") should be(false)
  }

  test("invalid credit card") {
    Luhn4.valid("8273 1232 7352 0569") should be(false)
  }

  test("valid strings with a non-digit included become invalid") {
    Luhn4.valid("055a 444 285") should be(false)
  }

  test("valid strings with punctuation included become invalid") {
    Luhn4.valid("055-444-285") should be(false)
  }

  test("valid strings with symbols included become invalid") {
    Luhn4.valid("055£ 444$ 285") should be(false)
  }

  test("single zero with space is invalid") {
    Luhn4.valid(" 0") should be(false)
  }

  test("more than a single zero is valid") {
    Luhn4.valid("0000 0") should be(true)
  }

  test("input digit 9 is correctly converted to output digit 9") {
    Luhn4.valid("091") should be(true)
  }

  test("strings with non-digits is invalid") {
    Luhn4.valid(":9") should be(false)
  }
}
