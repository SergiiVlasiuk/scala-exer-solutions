/// this solution is copy of different on (7th)

object VariableLengthQuantity {
  private[this] val ValueBits = 127
  private[this] val FlagBit = 128
  private[this] val Shift = 7

  def encode(numbers: List[Int]): List[Int] = numbers flatMap encode

  private def encode(number: Int): List[Int] = ((number & ValueBits) +: encodeRec(number >>> Shift)).reverse

  private def encodeRec(number: Int): List[Int] = number match {
    case 0 => List()
    case _ => ((number & ValueBits) | FlagBit) +: encodeRec(number >>> Shift)
  }

  def decode(bytes: List[Int]): Either[String, List[Int]] = {
    val partitions = partition(bytes)
    if (partitions.nonEmpty && (partitions.last.last & FlagBit) != 0) Left("Invalid sequence")
    else Right(partitions map decodeSingle)
  }

  private def decodeSingle(bytes: List[Int]): Int = bytes.foldLeft(0) { (sum, n) => (sum << Shift) | (n & ValueBits) }

  @scala.annotation.tailrec
  private def partition(
                         bytes: List[Int],
                         current: List[Int] = List(),
                         accumulator: List[List[Int]] = List()
                       ): List[List[Int]] =
    bytes match {
      case head +: tail if (head & FlagBit) == 0 => partition(tail, List(), (head +: current).reverse +: accumulator)
      case head +: tail => partition(tail, head +: current, accumulator)
      case List() if current.isEmpty => accumulator.reverse
      case List() => (current +: accumulator).reverse
    }
}
