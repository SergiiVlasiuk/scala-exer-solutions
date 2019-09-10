import org.scalatest.{FunSuite, Matchers}

/** @version 2.1.0 */
class NthPrime4Test extends FunSuite with Matchers {

  test("first prime") {
    NthPrime4.prime(1) should be(Some(2))
  }

  test("second prime") {
    NthPrime4.prime(2) should be(Some(3))
  }

  test("sixth prime") {
    NthPrime4.prime(6) should be(Some(13))
  }

  test("big prime") {
    NthPrime4.prime(10001) should be(Some(104743))
  }

  test("there is no zeroth prime") {
    NthPrime4.prime(0) should be(None)
  }
}
