object Grains2 {
  def square(squareNumber: Int): Option[BigInt] = {
    if ((1 to 64).contains(squareNumber)) {
      println(s"BigInt(2).pow($squareNumber - 1) = " + BigInt(2).pow(squareNumber - 1))
      Some(BigInt(2).pow(squareNumber - 1))
    } else None
  }

  def total: BigInt = BigInt(2).pow(64) - 1
}
