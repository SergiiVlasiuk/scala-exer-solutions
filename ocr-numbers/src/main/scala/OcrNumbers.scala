object OcrNumbers {
  private val parseDigit: Map[List[String], Char] =
    Map(List(" _ ", "| |", "|_|") -> '0',
      List("   ", "  |", "  |") -> '1',
      List(" _ ", " _|", "|_ ") -> '2',
      List(" _ ", " _|", " _|") -> '3',
      List("   ", "|_|", "  |") -> '4',
      List(" _ ", "|_ ", " _|") -> '5',
      List(" _ ", "|_ ", "|_|") -> '6',
      List(" _ ", "  |", "  |") -> '7',
      List(" _ ", "|_|", "|_|") -> '8',
      List(" _ ", "|_|", " _|") -> '9') withDefaultValue '?'

  private def convertLine(xs: List[String]): String =
    if (xs.head.length % 3 != 0) "?"
    else xs.map(_.grouped(3).toList).transpose.map(x => parseDigit(x.init)).mkString

  def convert(xs: List[String]): String =
    xs.grouped(4).map(convertLine).mkString(",")
}
