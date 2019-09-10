import org.scalatest.{FunSuite, Matchers}

/** @version 1.0.0 */
class Darts3Test extends FunSuite with Matchers {

  test("A dart lands outside the target") {
    Darts3.score(15.3, 13.2) should be(0)
  }

  test("A dart lands just in the border of the target") {
    Darts3.score(10, 0) should be(1)
  }

  test("A dart lands in the middle circle") {
    Darts3.score(3, 3.7) should be(5)
  }

  test("A dart lands right in the border between outside and middle circles") {
    Darts3.score(0, 5) should be(5)
  }

  test("A dart lands in the inner circle") {
    Darts3.score(0, 0) should be(10)
  }
}