import scala.annotation.tailrec

object VariableLengthQuantity3 {
  private val octetMask: Int = 0x7F

  def encode(n: List[Int]): Seq[Int] = {
    @tailrec
    def numberToOctets(n: Int, acc: Seq[Int] = Nil): Seq[Int] = {
      val next = n >>> 7
      val current = n & octetMask
      val newAcc = acc :+ current
      if (next == 0) newAcc
      else numberToOctets(next, newAcc)
    }

    def markOctets(n: Seq[Int]): Seq[Int] = {
      if (n.lengthCompare(1) == 0) n
      else {
        val last = n.length - 1
        n.zipWithIndex.map { case (o, idx) => if (idx != last) o | 0x80 else o }
      }
    }

    n.flatMap { number =>
      val octets = numberToOctets(number).reverse
      markOctets(octets)
    }
  }

  def decode(n: List[Int]): Either[Throwable, Seq[Int]] = {
    def decodeNumber(seq: Seq[Int]): Int = {
      seq.reverse.zipWithIndex.foldLeft(0) { case (carry, (current, idx)) =>
        carry | ((current & octetMask) << (idx * 7))
      }
    }

    def chunk(list: Seq[Int], acc: Seq[Seq[Int]] = Nil): Seq[Seq[Int]] = {
      if (list.isEmpty) acc
      else {
        def isNotLastOctetElement(v: Int) = (v & 0x80) != 0

        val values = list.takeWhile(isNotLastOctetElement)
        val rest = list.dropWhile(isNotLastOctetElement)
        if (rest.isEmpty) Nil //error handling - one of the chunks is not full.
        else chunk(rest.tail, acc :+ (values :+ rest.head))
      }
    }

    val result = chunk(n).map(decodeNumber)
    if (result.isEmpty) Left(new IllegalArgumentException("The octet list is not complete"))
    else Right(result)
  }
}
