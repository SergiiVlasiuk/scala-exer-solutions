import org.scalatest.{FunSuite, Matchers}

/** @version 2.1.0 */
class NthPrime3Test extends FunSuite with Matchers {

  test("first prime") {
    NthPrime3.prime(1) should be(Some(2))
  }

  test("second prime") {
    NthPrime3.prime(2) should be(Some(3))
  }

  test("sixth prime") {
    NthPrime3.prime(6) should be(Some(13))
  }

  test("big prime") {
    NthPrime3.prime(10001) should be(Some(104743))
  }

  test("there is no zeroth prime") {
    NthPrime3.prime(0) should be(None)
  }
}
