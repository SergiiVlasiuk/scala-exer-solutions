import scala.annotation.tailrec

object VariableLengthQuantity6 {

  implicit class StringToInt(input: String) {
    def base2toBase10: Int = input.foldLeft(0)((acc, i) => acc * 2 + i.asDigit)
  }

  def encode(ints: List[Int]): List[Int] = ints.flatMap(encodeInt)

  def decode(ints: List[Int]): Either[String, List[Int]] = {
    val copy = ints.map(_.toBinaryString).map(x => if(x.length<8) "0"+x else x)

    @tailrec
    def loop(rest: List[String], acc: List[Either[String, Int]]): List[Either[String, Int]] = rest match {
      case Nil => acc
      case digit :: Nil => acc :+ decodeInt(digit :: Nil)
      case _ => val index = rest.prefixLength(_.startsWith("1"))
        loop(rest.drop(index + 1), acc :+ decodeInt(rest.take(index + 1)))
    }

    val resultTmp = loop(copy, Nil)
    if (resultTmp.exists(_.isLeft)) Left("error") else Right(resultTmp.map(x => x.getOrElse(0)))
  }

  private def encodeInt(n: Int): List[Int] = {
    val copy = n.toBinaryString
    val rest = copy.length % 7
    val tmp = (if (rest != 0) "0" * (7 - rest) + copy else copy).sliding(7, 7).toList
    val result = if (tmp.size == 1) tmp.map(x => "0" + x) else tmp.init.map(x => "1" + x) :+ ("0" + tmp.last)
    result.map(_.base2toBase10)
  }

  private def decodeInt(input: List[String]): Either[String, Int] = {
    if (input.last.length == 8 && input.last.startsWith("1")) Left("incomplete sequence")
    else if (input.init.exists(_.startsWith("0"))) Left("incomplete sequence")
    else {
      val last = if (input.last.length == 8) input.last else "0" * (8 - input.last.length) + input.last
      Right((input.init :+ last).map(_.tail).mkString.base2toBase10)
    }
  }
}
