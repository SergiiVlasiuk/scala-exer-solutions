case class ComplexNumber(real: Double = 0, imaginary: Double = 0) {
  def +(that: ComplexNumber): ComplexNumber = ComplexNumber(real + that.real, imaginary + that.imaginary)

  def -(that: ComplexNumber): ComplexNumber = ComplexNumber(real - that.real, imaginary - that.imaginary)

  def *(that: ComplexNumber): ComplexNumber = ComplexNumber(
    real * that.real - imaginary * that.imaginary,
    that.real * imaginary + that.imaginary * real
  )

  def /(that: ComplexNumber): ComplexNumber = ComplexNumber(
    (real * that.real + imaginary * that.imaginary) / (that.real * that.real + that.imaginary * that.imaginary),
    (imaginary * that.real - real * that.imaginary) / (that.real * that.real + that.imaginary * that.imaginary)
  )

  def abs: Double = math.sqrt(real * real + imaginary * imaginary)

  def conjugate: ComplexNumber = ComplexNumber(real, -imaginary)
}

object ComplexNumber {
  def exp(c: ComplexNumber): ComplexNumber = ComplexNumber(
    Math.exp(c.real) * Math.cos(c.imaginary),
    Math.exp(c.real) * Math.sin(c.imaginary)
  )
}
