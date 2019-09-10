import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class SpiralMatrix2Test extends FunSuite with Matchers {

  test("empty spiral") {
    SpiralMatrix2.spiralMatrix(0) should be(List())
  }

  test("trivial spiral") {
    SpiralMatrix2.spiralMatrix(1) should be(List(List(1)))
  }

  test("spiral of size 2") {
    SpiralMatrix2.spiralMatrix(2) should be(List(List(1, 2), List(4, 3)))
  }

  test("spiral of size 3") {
    SpiralMatrix2.spiralMatrix(3) should be(
      List(List(1, 2, 3),
        List(8, 9, 4),
        List(7, 6, 5)))
  }

  test("spiral of size 4") {
    SpiralMatrix2.spiralMatrix(4) should be(
      List(List(1, 2, 3, 4),
        List(12, 13, 14, 5),
        List(11, 16, 15, 6),
        List(10, 9, 8, 7)))
  }

  test("spiral of size 5") {
    SpiralMatrix2.spiralMatrix(5) should be(
      List(List(1, 2, 3, 4, 5),
        List(16, 17, 18, 19, 6),
        List(15, 24, 25, 20, 7),
        List(14, 23, 22, 21, 8),
        List(13, 12, 11, 10, 9)))
  }

  test("spiral of size 6") {
    SpiralMatrix2.spiralMatrix(6) should
      be(List(List(1, 2, 3, 4, 5, 6),
        List(20, 21, 22, 23, 24, 7),
        List(19, 32, 33, 34, 25, 8),
        List(18, 31, 36, 35, 26, 9),
        List(17, 30, 29, 28, 27, 10),
        List(16, 15, 14, 13, 12, 11)))
  }

  test("spiral of size 7") {
    SpiralMatrix2.spiralMatrix(7) should
      be(List(List(1, 2, 3, 4, 5, 6, 7),
        List(24, 25, 26, 27, 28, 29, 8),
        List(23, 40, 41, 42, 43, 30, 9),
        List(22, 39, 48, 49, 44, 31, 10),
        List(21, 38, 47, 46, 45, 32, 11),
        List(20, 37, 36, 35, 34, 33, 12),
        List(19, 18, 17, 16, 15, 14, 13)))
  }
}
