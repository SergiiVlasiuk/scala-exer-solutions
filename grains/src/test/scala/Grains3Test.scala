import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class Grains3Test extends FunSuite with Matchers {

  test("1") {
    Grains3.square(1) should be(Some(1))
  }

  test("2") {
    Grains3.square(2) should be(Some(2))
  }

  test("3") {
    Grains3.square(3) should be(Some(4))
  }

  test("4") {
    Grains3.square(4) should be(Some(8))
  }

  test("16") {
    Grains3.square(16) should be(Some(32768))
  }

  test("32") {
    Grains3.square(32) should be(Some(BigInt("2147483648")))
  }

  test("64") {
    Grains3.square(64) should be(Some(BigInt("9223372036854775808")))
  }

  test("square 0 raises an exception") {
    Grains3.square(0) should be(None)
  }

  test("negative square raises an exception") {
    Grains3.square(-1) should be(None)
  }

  test("square greater than 64 raises an exception") {
    Grains3.square(65) should be(None)
  }

  test("returns the total number of grains on the board") {
    Grains3.total should be(BigInt("18446744073709551615"))
  }
}
