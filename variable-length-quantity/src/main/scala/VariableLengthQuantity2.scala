object VariableLengthQuantity2 {
  private val MaxByte = 0x7F
  private val Bit7 = 0x80
  private val LongMask = 0x00000000FFFFFFFFL

  @annotation.tailrec private def encodeBytes(dec: Long, acc: Seq[Int] = Seq()): Seq[Int] =
    if (dec <= 0) acc
    else encodeBytes(dec >>> 7, acc :+ (dec & MaxByte).toInt)

  private def encoded(n: Int): Seq[Int] =
    if (n == 0) Seq(0)
    else encodeBytes(LongMask & n).zipWithIndex.map {
      case (value, 0) => value
      case (value, _) => value | Bit7
    }.reverse

  def encode(args: Seq[Int]): Seq[Int] = args.flatMap(encoded)

  private def decodedDigits(vs: Seq[Int]): Seq[Seq[Int]] =
    vs.foldLeft(Seq[Seq[Int]]() -> Seq[Int]()) { case ((acc, current), next) =>
      if ((next & Bit7) == Bit7) acc -> (current :+ (next & MaxByte))
      else (acc :+ (current :+ next)) -> Seq()
    }._1

  private def decodedValues(vs: Seq[Int]): Seq[Int] = decodedDigits(vs).map { ds =>
    ds.reverse.zipWithIndex.foldLeft(0) { case (acc, (next, i)) => acc + (next << (7 * i)) }
  }

  def decode(args: Seq[Int]): Either[Unit, Seq[Int]] = {
    if (args.size == 1 && (args.head & Bit7) == Bit7) Left(())
    else Right(decodedValues(args))
  }
}