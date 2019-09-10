import org.scalatest.{FunSuite, Matchers}

/** @version 2.1.0 */
class NthPrime2Test extends FunSuite with Matchers {

  test("first prime") {
    NthPrime2.prime(1) should be(Some(2))
  }

  test("second prime") {
    NthPrime2.prime(2) should be(Some(3))
  }

  test("sixth prime") {
    NthPrime2.prime(6) should be(Some(13))
  }

  test("big prime") {
    NthPrime2.prime(10001) should be(Some(104743))
  }

  test("there is no zeroth prime") {
    NthPrime2.prime(0) should be(None)
  }
}
