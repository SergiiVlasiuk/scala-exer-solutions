object Raindrops4 {

  private def noise(s: String, factor: Int)(num: Int): String = if (num % factor == 0) s else ""

  private def pling: Int => String = noise("Pling", 3) _

  private def plang = noise("Plang", 5) _

  private def plong = noise("Plong", 7) _

  def convert(num: Int): String = {
    val res = pling(num) + plang(num) + plong(num)
    if (res.isEmpty) num.toString else res
  }
}

