import org.scalatest.{FunSuite, Matchers}

class LargestSeriesProduct4Test extends FunSuite with Matchers {

  test("finds the largest product if span equals length") {
    Series4.largestProduct(2, "29") should be(Some(18))
  }

  test("can find the largest product of 2 with numbers in order") {
    Series4.largestProduct(2, "0123456789") should be(Some(72))
  }

  test("can find the largest product of 2") {
    Series4.largestProduct(2, "576802143") should be(Some(48))
  }

  test("can find the largest product of 3 with numbers in order") {
    Series4.largestProduct(3, "0123456789") should be(Some(504))
  }

  test("can find the largest product of 3") {
    Series4.largestProduct(3, "1027839564") should be(Some(270))
  }

  test("can find the largest product of 5 with numbers in order") {
    Series4.largestProduct(5, "0123456789") should be(Some(15120))
  }

  test("can get the largest product of a big number") {
    Series4.largestProduct(6,
      "73167176531330624919225119674426574742355349194934") should be(Some(23520))
  }

  test("reports zero if the only digits are zero") {
    Series4.largestProduct(2, "0000") should be(Some(0))
  }

  test("reports zero if all spans include zero") {
    Series4.largestProduct(3, "99099") should be(Some(0))
  }

  test("rejects span longer than string length") {
    Series4.largestProduct(4, "123") should be(None)
  }

  test("reports 1 for empty string and empty product (0 span)") {
    Series4.largestProduct(0, "") should be(Some(1))
  }

  test("reports 1 for nonempty string and empty product (0 span)") {
    Series4.largestProduct(0, "123") should be(Some(1))
  }

  test("rejects empty string and nonzero span") {
    Series4.largestProduct(1, "") should be(None)
  }

  test("rejects invalid character in digits") {
    Series4.largestProduct(2, "1234a5") should be(None)
  }

  test("rejects negative span") {
    Series4.largestProduct(-1, "12345") should be(None)
  }
}
