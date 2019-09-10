object ComplexNumber2 {
  def exp(z: ComplexNumber2): ComplexNumber2 =
    ComplexNumber2(math.exp(z.real) * math.cos(z.imaginary), math.exp(z.real) * math.sin(z.imaginary))
}

case class ComplexNumber2(real: Double = 0.0, imaginary: Double = 0.0) {
  def +(that: ComplexNumber2): ComplexNumber2 = ComplexNumber2(real + that.real, imaginary + that.imaginary)

  def -(that: ComplexNumber2): ComplexNumber2 = ComplexNumber2(real - that.real, imaginary - that.imaginary)

  def *(that: ComplexNumber2): ComplexNumber2 =
    ComplexNumber2(real * that.real - imaginary * that.imaginary, imaginary * that.real + real * that.imaginary)

  def /(that: ComplexNumber2): ComplexNumber2 = {
    val denominator = math.pow(that.real, 2) + math.pow(that.imaginary, 2)
    ComplexNumber2((real * that.real + imaginary * that.imaginary) / denominator,
      (imaginary * that.real - real * that.imaginary) / denominator)
  }

  def abs: Double = math.hypot(real, imaginary)

  def conjugate: ComplexNumber2 = ComplexNumber2(real, -imaginary)
}
