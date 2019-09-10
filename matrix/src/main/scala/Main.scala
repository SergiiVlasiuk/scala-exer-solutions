object Main {
  def main(args: Array[String]): Unit = {
    val inp = "1 2 3\n" +
      "4 5 6\n" +
      "7 8 9\n" +
      "8 7 6"

    println(s"inp: $inp")
    println(s"inp: ${inp.linesIterator.toList}")
  }
}
