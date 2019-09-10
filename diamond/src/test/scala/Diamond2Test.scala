import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class Diamond2Test extends FunSuite with Matchers {

  test("Degenerate case with a single 'A' row") {
    Diamond2.rows('A') should be(List("A"))
  }

  test("Degenerate case with no row containing 3 distinct groups of spaces") {
    Diamond2.rows('B') should be(List(" A ", "B B", " A "))
  }

  test("Smallest non-degenerate case with odd diamond side length") {
    Diamond2.rows('C') should be(
      List("  A  ", " B B ", "C   C", " B B ", "  A  "))
  }

  test("Smallest non-degenerate case with even diamond side length") {
    Diamond2.rows('D') should be(
      List("   A   ",
        "  B B  ",
        " C   C ",
        "D     D",
        " C   C ",
        "  B B  ",
        "   A   "))
  }

  test("Largest possible diamond") {
    Diamond2.rows('Z') should be(
      List(
        "                         A                         ",
        "                        B B                        ",
        "                       C   C                       ",
        "                      D     D                      ",
        "                     E       E                     ",
        "                    F         F                    ",
        "                   G           G                   ",
        "                  H             H                  ",
        "                 I               I                 ",
        "                J                 J                ",
        "               K                   K               ",
        "              L                     L              ",
        "             M                       M             ",
        "            N                         N            ",
        "           O                           O           ",
        "          P                             P          ",
        "         Q                               Q         ",
        "        R                                 R        ",
        "       S                                   S       ",
        "      T                                     T      ",
        "     U                                       U     ",
        "    V                                         V    ",
        "   W                                           W   ",
        "  X                                             X  ",
        " Y                                               Y ",
        "Z                                                 Z",
        " Y                                               Y ",
        "  X                                             X  ",
        "   W                                           W   ",
        "    V                                         V    ",
        "     U                                       U     ",
        "      T                                     T      ",
        "       S                                   S       ",
        "        R                                 R        ",
        "         Q                               Q         ",
        "          P                             P          ",
        "           O                           O           ",
        "            N                         N            ",
        "             M                       M             ",
        "              L                     L              ",
        "               K                   K               ",
        "                J                 J                ",
        "                 I               I                 ",
        "                  H             H                  ",
        "                   G           G                   ",
        "                    F         F                    ",
        "                     E       E                     ",
        "                      D     D                      ",
        "                       C   C                       ",
        "                        B B                        ",
        "                         A                         "
      ))
  }
}
