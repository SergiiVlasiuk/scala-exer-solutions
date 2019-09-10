object Wordy8 {
  private def getFunc(s: String): Option[(Int, Int) => Int] = s match {
    case "plus" => Some(_ + _)
    case "minus" => Some(_ - _)
    case "multiplied" => Some(_ * _)
    case "divided" => Some(_ / _)
    case _ => None
  }

  def answer(str: String): Option[Int] = {
    val s = str.stripPrefix("What is ").stripSuffix("?").replaceAll(" by", "")

    def inner(l: List[String]): Option[Int] = l match {
      case Nil => None
      case acc :: Nil => Some(acc.toInt)
      case v1 :: f :: v2 :: t =>
        val nf = getFunc(f)
        if (nf.isDefined)
          inner(nf.get(v1.toInt, v2.toInt).toString :: t)
        else
          None
      case _ => None
    }

    inner(s.split(" ").toList)
  }
}
