object RunLengthEncoding {
  def decode(str: String): String = str match {
    case "" => ""
    case s => {
      val (h, t) = s.span(_.isDigit)
      if (h.length > 0) t.head.toString * h.toInt + decode(t.tail)
      else t.head + decode(t.tail)
    }
  }

  def encode(str: String): String = {
    def enc_(list: List[(Char, Int)]): List[(Char, Int)] = list match {
      case h1 :: h2 :: tail if h1._1 == h2._1 => enc_((h1._1, h1._2 + 1) :: tail)
      case h1 :: h2 :: tail => h1 :: enc_((h2._1, 1) :: tail)
      case head :: Nil => list
      case Nil => List.empty
    }

    enc_(str.toList.zip(Stream from 1)).map {
      case (ch, 1) => ch.toString
      case (ch, dig) => dig.toString + ch
    }.mkString
  }
}
