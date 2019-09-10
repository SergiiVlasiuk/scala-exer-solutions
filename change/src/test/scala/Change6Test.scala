import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class Change6Test extends FunSuite with Matchers {

  test("single coin change") {
    Change6.findFewestCoins(25, List(1, 5, 10, 25, 100)) should be(Some(List(25)))
  }

  test("multiple coin change") {
    Change6.findFewestCoins(15, List(1, 5, 10, 25, 100)) should be(Some(List(5, 10)))
  }

  test("change with Lilliputian Coins") {
    Change6.findFewestCoins(23, List(1, 4, 15, 20, 50)) should be(Some(List(4, 4, 15)))
  }

  test("change with Lower Elbonia Coins") {
    Change6.findFewestCoins(63, List(1, 5, 10, 21, 25)) should be(Some(List(21, 21, 21)))
  }

  test("large target values") {
    Change6.findFewestCoins(999, List(1, 2, 5, 10, 20, 50, 100)) should be(Some(List(2, 2, 5, 20, 20, 50, 100, 100, 100, 100, 100, 100, 100, 100, 100)))
  }

  test("possible change without unit coins available") {
    Change6.findFewestCoins(21, List(2, 5, 10, 20, 50)) should be(Some(List(2, 2, 2, 5, 10)))
  }

  test("another possible change without unit coins available") {
    Change6.findFewestCoins(27, List(4, 5)) should be(Some(List(4, 4, 4, 5, 5, 5)))
  }

  test("no coins make 0 change") {
    Change6.findFewestCoins(0, List(1, 5, 10, 21, 25)) should be(Some(List()))
  }

  test("error testing for change smaller than the smallest of coins") {
    Change6.findFewestCoins(3, List(5, 10)) should be(None)
  }

  test("error if no combination can add up to target") {
    Change6.findFewestCoins(94, List(5, 10)) should be(None)
  }

  test("cannot find negative change values") {
    Change6.findFewestCoins(-5, List(1, 2, 5)) should be(None)
  }
}