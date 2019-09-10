import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class RotationalCipher4Test extends FunSuite with Matchers {

  test("rotate a by 0, same output as input") {
    RotationalCipher4.rotate("a", 0) should be("a")
  }

  test("rotate a by 1") {
    RotationalCipher4.rotate("a", 1) should be("b")
  }

  test("rotate a by 26, same output as input") {
    RotationalCipher4.rotate("a", 26) should be("a")
  }

  test("rotate m by 13") {
    RotationalCipher4.rotate("m", 13) should be("z")
  }

  test("rotate n by 13 with wrap around alphabet") {
    RotationalCipher4.rotate("n", 13) should be("a")
  }

  test("rotate capital letters") {
    RotationalCipher4.rotate("OMG", 5) should be("TRL")
  }

  test("rotate spaces") {
    RotationalCipher4.rotate("O M G", 5) should be("T R L")
  }

  test("rotate numbers") {
    RotationalCipher4.rotate("Testing 1 2 3 testing", 4) should be(
      "Xiwxmrk 1 2 3 xiwxmrk")
  }

  test("rotate punctuation") {
    RotationalCipher4.rotate("Let's eat, Grandma!", 21) should be(
      "Gzo'n zvo, Bmviyhv!")
  }

  test("rotate all letters") {
    RotationalCipher4.rotate("The quick brown fox jumps over the lazy dog.", 13) should be(
      "Gur dhvpx oebja sbk whzcf bire gur ynml qbt.")
  }
}
