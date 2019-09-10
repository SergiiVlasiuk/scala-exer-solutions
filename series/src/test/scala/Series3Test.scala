import org.scalatest.{FunSuite, Matchers}

/** @version created manually **/
class Series3Test extends FunSuite with Matchers {

  test("slices of one") {
    Series3.slices(1, "") should be(List())
    Series3.slices(1, "01234") should be(List(List(0), List(1), List(2), List(3), List(4)))
  }

  test("slices of two") {
    Series3.slices(2, "") should be(List())
    Series3.slices(2, "01") should be(List(List(0, 1)))
    Series3.slices(2, "01234") should be(List(List(0, 1), List(1, 2), List(2, 3), List(3, 4)))
  }

  test("slices of three") {
    Series3.slices(3, "") should be(List())
    Series3.slices(3, "012") should be(List(List(0, 1, 2)))
    Series3.slices(3, "01234") should be(List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4)))
  }
}
