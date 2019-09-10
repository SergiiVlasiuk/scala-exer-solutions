import DecodingError.DecodingError

import scala.annotation.tailrec

object DecodingError extends Enumeration {
  type DecodingError = Value
  val IncompleteNumber: Value = Value
}

object VariableLengthQuantity4 {
  private val ChunkMask = 0x7f
  private val ChunkSize = 7
  private val MostSignificantBit = 0x80

  private def bytes(n: Int): List[Int] = {
    @tailrec
    def helper(remaining: Int, result: List[Int]): List[Int] =
      if (remaining == 0) result
      else helper(remaining >>> ChunkSize, (remaining & ChunkMask) :: result)

    helper(n >>> ChunkSize, List(n & ChunkMask))
  }

  private def encodeNumber(n: Int): List[Int] = (bytes(n).reverse: @unchecked) match {
    case b :: bs => (b :: bs.map(_ | MostSignificantBit)).reverse
  }

  private def extractNumbers(values: List[Int]): List[List[Int]] =
    values.foldRight(List[List[Int]]())((v, a) =>
      if ((v & MostSignificantBit) == 0) List(v) :: a else (v :: a.head) :: a.tail
    )

  private def decodeNumber(values: List[Int]): Int = (values.reverse: @unchecked) match {
    case b :: bs => (b :: bs.map(_ & ~MostSignificantBit)).foldRight(0)((x, a) => (a << ChunkSize) | x)
  }

  def encode(values: List[Int]): List[Int] = values.flatMap(encodeNumber)

  def decode(values: List[Int]): Either[DecodingError, List[Int]] =
    if ((values.lastOption.getOrElse(0) & MostSignificantBit) != 0) Left(DecodingError.IncompleteNumber)
    else Right(extractNumbers(values).map(decodeNumber))
}
