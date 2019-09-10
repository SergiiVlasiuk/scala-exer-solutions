import org.scalatest.{FunSuite, Matchers}

/** @version 1.3.0 */
class ComplexNumber2Test extends FunSuite with Matchers {

  private val equalityEpsilon = 1e-15

  private def assertEquals(c1: ComplexNumber2, c2: ComplexNumber2) {
    c1.real should be(c2.real +- equalityEpsilon)
    c1.imaginary should be(c2.imaginary +- equalityEpsilon)
  }

  test("Real part of a purely real number") {
    ComplexNumber2(real = 1).real should be(1.0 +- equalityEpsilon)
  }

  test("Real part of a purely imaginary number") {
    ComplexNumber2(real = 0).real should be(0.0 +- equalityEpsilon)
  }

  test("Real part of a number with real and imaginary part") {
    ComplexNumber2(real = 1).real should be(1.0 +- equalityEpsilon)
  }

  test("Imaginary part of a purely real number") {
    ComplexNumber2(imaginary = 0).imaginary should be(0.0 +- equalityEpsilon)
  }

  test("Imaginary part of a purely imaginary number") {
    ComplexNumber2(imaginary = 1).imaginary should be(1.0 +- equalityEpsilon)
  }

  test("Imaginary part of a number with real and imaginary part") {
    ComplexNumber2(imaginary = 2).imaginary should be(2.0 +- equalityEpsilon)
  }

  test("Imaginary unit") {
    val result = ComplexNumber2(0, 1) * ComplexNumber2(0, 1)
    assertEquals(result, ComplexNumber2(-1, 0))
  }

  test("Add purely real numbers") {
    val result = ComplexNumber2(1, 0) + ComplexNumber2(2, 0)
    assertEquals(result, ComplexNumber2(3, 0))
  }

  test("Add purely imaginary numbers") {
    val result = ComplexNumber2(0, 1) + ComplexNumber2(0, 2)
    assertEquals(result, ComplexNumber2(0, 3))
  }

  test("Add numbers with real and imaginary part") {
    val result = ComplexNumber2(1, 2) + ComplexNumber2(3, 4)
    assertEquals(result, ComplexNumber2(4, 6))
  }

  test("Subtract purely real numbers") {
    val result = ComplexNumber2(1, 0) - ComplexNumber2(2, 0)
    assertEquals(result, ComplexNumber2(-1, 0))
  }

  test("Subtract purely imaginary numbers") {
    val result = ComplexNumber2(0, 1) - ComplexNumber2(0, 2)
    assertEquals(result, ComplexNumber2(0, -1))
  }

  test("Subtract numbers with real and imaginary part") {
    val result = ComplexNumber2(1, 2) - ComplexNumber2(3, 4)
    assertEquals(result, ComplexNumber2(-2, -2))
  }

  test("Multiply purely real numbers") {
    val result = ComplexNumber2(1, 0) * ComplexNumber2(2, 0)
    assertEquals(result, ComplexNumber2(2, 0))
  }

  test("Multiply purely imaginary numbers") {
    val result = ComplexNumber2(0, 1) * ComplexNumber2(0, 2)
    assertEquals(result, ComplexNumber2(-2, 0))
  }

  test("Multiply numbers with real and imaginary part") {
    val result = ComplexNumber2(1, 2) * ComplexNumber2(3, 4)
    assertEquals(result, ComplexNumber2(-5, 10))
  }

  test("Divide purely real numbers") {
    val result = ComplexNumber2(1, 0) / ComplexNumber2(2, 0)
    assertEquals(result, ComplexNumber2(0.5, 0))
  }

  test("Divide purely imaginary numbers") {
    val result = ComplexNumber2(0, 1) / ComplexNumber2(0, 2)
    assertEquals(result, ComplexNumber2(0.5, 0))
  }

  test("Divide numbers with real and imaginary part") {
    val result = ComplexNumber2(1, 2) / ComplexNumber2(3, 4)
    assertEquals(result, ComplexNumber2(0.44, 0.08))
  }

  test("Absolute value of a positive purely real number") {
    ComplexNumber2(5, 0).abs should be(5.0 +- equalityEpsilon)
  }

  test("Absolute value of a negative purely real number") {
    ComplexNumber2(-5, 0).abs should be(5.0 +- equalityEpsilon)
  }

  test("Absolute value of a purely imaginary number with positive imaginary part") {
    ComplexNumber2(0, 5).abs should be(5.0 +- equalityEpsilon)
  }

  test("Absolute value of a purely imaginary number with negative imaginary part") {
    ComplexNumber2(0, -5).abs should be(5.0 +- equalityEpsilon)
  }

  test("Absolute value of a number with real and imaginary part") {
    ComplexNumber2(3, 4).abs should be(5.0 +- equalityEpsilon)
  }

  test("Conjugate a purely real number") {
    val result = ComplexNumber2(5, 0).conjugate
    assertEquals(result, ComplexNumber2(5, 0))
  }

  test("Conjugate a purely imaginary number") {
    val result = ComplexNumber2(0, 5).conjugate
    assertEquals(result, ComplexNumber2(0, -5))
  }

  test("Conjugate a number with real and imaginary part") {
    val result = ComplexNumber2(1, 1).conjugate
    assertEquals(result, ComplexNumber2(1, -1))
  }

  test("Euler's identity/formula") {
    val result = ComplexNumber2.exp(ComplexNumber2(0, math.Pi))
    assertEquals(result, ComplexNumber2(-1, 0))
  }

  test("Exponential of 0") {
    val result = ComplexNumber2.exp(ComplexNumber2(0, 0))
    assertEquals(result, ComplexNumber2(1, 0))
  }

  test("Exponential of a purely real number") {
    val result = ComplexNumber2.exp(ComplexNumber2(1, 0))
    assertEquals(result, ComplexNumber2(math.E, 0))
  }

  test("Exponential of a number with real and imaginary part") {
    val result = ComplexNumber2.exp(ComplexNumber2(math.log(2), math.Pi))
    assertEquals(result, ComplexNumber2(-2, 0))
  }
}
