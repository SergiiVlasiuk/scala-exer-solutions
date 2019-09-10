object ArmstrongNumbers {

  // https://exercism.io/profiles/gerdreiss
  def isArmstrongNumber(number: Int): Boolean = {
    val digits = number.toString
    val digitize: Char => Int = _.asDigit
    val power: Int => Double = math.pow(_, digits.length)
    number == digits.map(digitize andThen power).sum
  }

//  // https://exercism.io/profiles/djmoorejr
//  def isArmstrongNumber( i: Int ): Boolean = {
//    val len = i.toString.length
//    i.toString.map(c => Math.pow(c.asDigit, len).toInt).sum == i
//  }


































/*
  def isArmstrongNumber(param: Int): Boolean = {

    def size(int: Int): Int =
      if (int <= 0) 0
      else 1 + size(int / 10)

    val power = size(param)

    def calculateSum(f: (Int, Int) => Int)(param: Int): Int =
      if (param > 0) f(param % 10, power) + calculateSum(f)(param / 10)
      else 0

    def calculatePower(base: Int, power: Int): Int =
      if (power > 0) base * calculatePower(base, power - 1)
      else 1

    param == calculateSum(calculatePower)(param)
  }
*/

}
