object Raindrops3 {

  def convert(n: Int): String = {
    val f = 1.to(n).filter(x => n % x == 0).toList
    val code = "" + (if (f.contains(3)) "Pling" else "") + (if (f.contains(5)) "Plang" else "") + (if (f.contains(7)) "Plong" else "")
    if (code.length > 1) code else n.toString
  }
}

