object AllYourBase2 {

  def digitsToValue(inputBase: Int, inputDigits: List[Int]): Int =
    inputDigits.reverse
      .zip((0 to inputDigits.size).toList)
      .map(t => t._1 * scala.math.pow(inputBase, t._2).toInt)
      .sum

  def valueToDigits(outputBase: Int, inputValue: Int): List[Int] =
    Stream.from(0)
      .map(n => scala.math.pow(outputBase, n).toInt)
      .takeWhile(_ <= inputValue)
      .foldRight((Nil: List[Int], inputValue))((n, acc) => {
        val m = acc._2 / n
        (m :: acc._1, acc._2 - m * n)
      })
      ._1
      .reverse

  def rebase(inputBase: Int, inputDigits: List[Int], outputBase: Int): Option[List[Int]] =
    if (inputBase < 2 || outputBase < 2)
      None
    else if (inputDigits.exists(d => d < 0 || d >= inputBase))
      None
    else if (inputDigits.sum == 0)
      Some(List(0))
    else
      Some(valueToDigits(outputBase, digitsToValue(inputBase, inputDigits)))

}