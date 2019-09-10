object Robot {
  private val iterator = Stream from(0) iterator
  private val first = 'A' toInt
  private val dif: Int = 'Z' - 'A' + 1

  private def handleDigits(plus: Int): String = (plus + 1000).toString takeRight 3

  private def handleChars(plus: Int): String = s"${(plus / dif + first).toChar}${(plus % dif + first).toChar}"

  def generateNext: String = {
    val next = iterator.next()
    s"${handleChars(next)}${handleDigits(next / 1000)}"
  }
}

import Robot.generateNext

class Robot {
  private var robotName: String = generateNext

  def name: String = robotName

  def reset(): Unit = robotName = generateNext
}
