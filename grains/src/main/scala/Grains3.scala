object Grains3 {
  def square(squareNumber: Int): Option[BigInt] = squareNumber - 1 match {
    case x if x < 0 | x > 63 => None
    case x => Some(BigInt(2).pow(x))
  }

  //  def total: BigInt = (1 to 64).flatMap(square).sum
  def total: BigInt = BigInt(2).pow(64) - 1
}
