import org.scalatest.{FunSuite, Matchers}

class SaddlePoints3Test extends FunSuite with Matchers {

  test("Can identify single saddle point") {
    Matrix3(List(List(9, 8, 7), List(5, 3, 2), List(6, 6, 7))).saddlePoints should be(Set((1, 0)))
  }

  test("Can identify that empty matrix has no saddle points") {
    Matrix3(List(List())).saddlePoints should be(Set())
  }

  test("Can identify lack of saddle points when there are none") {
    Matrix3(List(List(1, 2, 3), List(3, 1, 2), List(2, 3, 1))).saddlePoints should be(Set())
  }

  test("Can identify multiple saddle points") {
    Matrix3(List(List(4, 5, 4), List(3, 5, 5), List(1, 5, 4))).saddlePoints should be(Set((0, 1), (1, 1), (2, 1)))
  }

  test("Can identify saddle point in bottom right corner") {
    Matrix3(List(List(8, 7, 9), List(6, 7, 6), List(3, 2, 5))).saddlePoints should be(Set((2, 2)))
  }
}
