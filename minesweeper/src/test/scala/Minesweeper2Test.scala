import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class Minesweeper2Test extends FunSuite with Matchers {

  test("no rows") {
    Minesweeper2.annotate(List()) should be(List())
  }

  test("no columns") {
    Minesweeper2.annotate(List("")) should be(List(""))
  }

  test("no mines") {
    Minesweeper2.annotate(List("   ",
      "   ",
      "   ")) should be(
      List("   ",
        "   ",
        "   "))
  }

  test("minefield with only mines") {
    Minesweeper2.annotate(List("***",
      "***",
      "***")) should be(
      List("***",
        "***",
        "***"))
  }

  test("mine surrounded by spaces") {
    Minesweeper2.annotate(List("   ",
      " * ",
      "   ")) should be(
      List("111",
        "1*1",
        "111"))
  }

  test("space surrounded by mines") {
    Minesweeper2.annotate(List("***",
      "* *",
      "***")) should be(
      List("***",
        "*8*",
        "***"))
  }

  test("horizontal line") {
    Minesweeper2.annotate(List(" * * ")) should be(List("1*2*1"))
  }

  test("horizontal line, mines at edges") {
    Minesweeper2.annotate(List("*   *")) should be(List("*1 1*"))
  }

  test("vertical line") {
    Minesweeper2.annotate(List(" ",
      "*",
      " ",
      "*",
      " ")) should be(
      List("1",
        "*",
        "2",
        "*",
        "1"))
  }

  test("vertical line, mines at edges") {
    Minesweeper2.annotate(List("*",
      " ",
      " ",
      " ",
      "*")) should be(
      List("*",
        "1",
        " ",
        "1",
        "*"))
  }

  test("cross") {
    Minesweeper2.annotate(List("  *  ",
      "  *  ",
      "*****",
      "  *  ",
      "  *  ")) should be(
      List(" 2*2 ",
        "25*52",
        "*****",
        "25*52",
        " 2*2 "))
  }

  test("large minefield") {
    Minesweeper2.annotate(List(" *  * ",
      "  *   ",
      "    * ",
      "   * *",
      " *  * ",
      "      ")) should be(
      List("1*22*1",
        "12*322",
        " 123*2",
        "112*4*",
        "1*22*2",
        "111111"))
  }
}
