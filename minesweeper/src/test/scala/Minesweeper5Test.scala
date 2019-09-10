import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class Minesweeper5Test extends FunSuite with Matchers {

  test("no rows") {
    Minesweeper5.annotate(List()) should be(List())
  }

  test("no columns") {
    Minesweeper5.annotate(List("")) should be(List(""))
  }

  test("no mines") {
    Minesweeper5.annotate(List("   ",
      "   ",
      "   ")) should be(
      List("   ",
        "   ",
        "   "))
  }

  test("minefield with only mines") {
    Minesweeper5.annotate(List("***",
      "***",
      "***")) should be(
      List("***",
        "***",
        "***"))
  }

  test("mine surrounded by spaces") {
    Minesweeper5.annotate(List("   ",
      " * ",
      "   ")) should be(
      List("111",
        "1*1",
        "111"))
  }

  test("space surrounded by mines") {
    Minesweeper5.annotate(List("***",
      "* *",
      "***")) should be(
      List("***",
        "*8*",
        "***"))
  }

  test("horizontal line") {
    Minesweeper5.annotate(List(" * * ")) should be(List("1*2*1"))
  }

  test("horizontal line, mines at edges") {
    Minesweeper5.annotate(List("*   *")) should be(List("*1 1*"))
  }

  test("vertical line") {
    Minesweeper5.annotate(List(" ",
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
    Minesweeper5.annotate(List("*",
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
    Minesweeper5.annotate(List("  *  ",
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
    Minesweeper5.annotate(List(" *  * ",
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
