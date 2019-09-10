import org.scalatest.{FunSuite, Matchers}

class PrimeFactors3Test extends FunSuite with Matchers {

  test("no factors") {
    PrimeFactors3.factors(1) should be(List())
  }

  test("prime number") {
    PrimeFactors3.factors(2) should be(List(2))
  }

  test("square of a prime") {
    PrimeFactors3.factors(9) should be(List(3, 3))
  }

  test("cube of a prime") {
    PrimeFactors3.factors(8) should be(List(2, 2, 2))
  }

  test("product of primes and non-primes") {
    PrimeFactors3.factors(12) should be(List(2, 2, 3))
  }

  test("product of primes") {
    PrimeFactors3.factors(901255) should be(List(5, 17, 23, 461))
  }

  test("factors include a large prime") {
    PrimeFactors3.factors(93819012551l) should be(List(11, 9539, 894119))
  }
}
