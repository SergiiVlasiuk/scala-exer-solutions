object Robot8 {
  val iterator = Stream.from(0).iterator
  val first = 'A'
  val dif: Int = 'Z' - 'A' + 1

  private def handleDigits(plus: Int): String = (plus + 1000).toString takeRight 3

  private def handleChars(plus: Int): String = s"${(plus / dif + first).toChar}${(plus % dif + first).toChar}"

  def generateNext: String = {
    val next = iterator.next()
    s"${handleChars(next)}${handleDigits(next / 1000)}"
  }
}

class Robot8 {
  private var robotName: String = Robot8.generateNext

  def name: String = robotName

  def reset(): Unit = robotName = Robot8.generateNext
}
