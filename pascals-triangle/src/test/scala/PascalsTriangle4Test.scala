import org.scalatest.{FunSuite, Matchers}

/** @version 1.3.0 */
class PascalsTriangle4Test extends FunSuite with Matchers {

  test("zero rows") {
    PascalsTriangle4.rows(0) should be(List())
  }

  test("single row") {
    PascalsTriangle4.rows(1) should be(List(List(1)))
  }

  test("two rows") {
    PascalsTriangle4.rows(2) should be(List(List(1), List(1, 1)))
  }

  test("three rows") {
    PascalsTriangle4.rows(3) should be(List(List(1), List(1, 1), List(1, 2, 1)))
  }

  test("four rows") {
    PascalsTriangle4.rows(4) should be(
      List(List(1), List(1, 1), List(1, 2, 1), List(1, 3, 3, 1)))
  }

  test("five rows") {
    PascalsTriangle4.rows(5) should be(
      List(List(1),
        List(1, 1),
        List(1, 2, 1),
        List(1, 3, 3, 1),
        List(1, 4, 6, 4, 1)))
  }

  test("six rows") {
    PascalsTriangle4.rows(6) should be(
      List(List(1),
        List(1, 1),
        List(1, 2, 1),
        List(1, 3, 3, 1),
        List(1, 4, 6, 4, 1),
        List(1, 5, 10, 10, 5, 1)))
  }

  test("ten rows") {
    PascalsTriangle4.rows(10) should be(
      List(
        List(1),
        List(1, 1),
        List(1, 2, 1),
        List(1, 3, 3, 1),
        List(1, 4, 6, 4, 1),
        List(1, 5, 10, 10, 5, 1),
        List(1, 6, 15, 20, 15, 6, 1),
        List(1, 7, 21, 35, 35, 21, 7, 1),
        List(1, 8, 28, 56, 70, 56, 28, 8, 1),
        List(1, 9, 36, 84, 126, 126, 84, 36, 9, 1)
      ))
  }

  test("negative rows") {
    PascalsTriangle4.rows(-1) should be(List())
  }
}
