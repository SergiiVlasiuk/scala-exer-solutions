import org.scalatest.{FunSuite, Matchers}

class Matrix2Test extends FunSuite with Matchers {

  test("extract row from one number matrix") {
    Matrix2("1").row(0) should be(Vector(1))
  }

  test("can extract row") {
    Matrix2("1 2\n" +
      "3 4").row(1) should be(Vector(3, 4))
  }

  test("extract row where numbers have different widths") {
    Matrix2("1 2\n" +
      "10 20").row(1) should be(Vector(10, 20))
  }

  test("can extract row from non-square matrix") {
    Matrix2("1 2 3\n"
      + "4 5 6\n"
      + "7 8 9\n"
      + "8 7 6").row(2) should be(Vector(7, 8, 9))
  }

  test("extract column from one number matrix") {
    Matrix2("1").column(0) should be(Vector(1))
  }

  test("can extract column") {
    Matrix2("1 2 3\n"
      + "4 5 6\n"
      + "7 8 9").column(2) should be(Vector(3, 6, 9))
  }

  test("can extract column from non-square matrix") {
    Matrix2("1 2 3\n"
      + "4 5 6\n"
      + "7 8 9\n"
      + "8 7 6").column(2) should be(Vector(3, 6, 9, 6))
  }

  test("extract column where numbers have different widths") {
    Matrix2("89 1903 3\n"
      + "18 3 1\n"
      + "9 4 800").column(1) should be(Vector(1903, 3, 4))
  }
}
