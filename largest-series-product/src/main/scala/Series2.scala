object Series2 {
  def largestProduct(size: Int, data: String): Option[Int] = {
    if (invalidInput(size, data)) None
    else if (size == 0) Some(1)
    else
      Some(data.split("").map(c => c.toInt).tails.map(s => {
        if (s.length >= size) s.take(size).product else 0
      }).max)
  }

  private def invalidInput(size: Int, data: String): Boolean =
    data.length < size || (data.length == 0 && size != 0) || size < 0 || "[a-zA-Z]".r.findFirstMatchIn(data).isDefined
}
