object Diamond4 {
  def rows(c: Char) = (Seq.range('A', c) ++ Seq(c) ++ Seq.range('A', c).reverse).map({
    case 'A' => ('A', (maxWidth(c) - 1) / 2, 0)
    case y => (y, c - y,  maxWidth(y) - 2)
  }).map({
    case (c, sides: Int, middle: Int) => {
      val sidePart: String = Seq.range(0, sides).map(_ => " ").foldLeft("")(_ + _)
      val middlePart: String = Seq.range(0, middle).map(_ => " ").foldLeft("")(_ + _)
      middle match {
        case 0 => sidePart + c.toString + sidePart
        case _ => sidePart + c.toString + middlePart + c.toString + sidePart
      }
    }
  })

  private def maxWidth(x: Char): Int = 2*(x - '@') - 1
}
