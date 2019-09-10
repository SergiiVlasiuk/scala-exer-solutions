import scala.collection.immutable.TreeMap

object Say {
  type NumberLookupType = (Long, Long, Long, String)
  type NumberOfSp = (Long, Long, String)
  val MaxVal = 999999999999l
  private val vocabulary: Map[Long, String] = TreeMap(
    1l -> "one",
    2l -> "two",
    3l -> "three",
    4l -> "four",
    5l -> "five",
    6l -> "six",
    7l -> "seven",
    8l -> "eight",
    9l -> "nine",
    10l -> "ten",
    11l -> "eleven",
    12l -> "twelve",
    13l -> "thirteen",
    14l -> "fourteen",
    15l -> "fifteen",
    16l -> "sixteen",
    17l -> "seventeen",
    18l -> "eighteen",
    19l -> "nineteen",
    20l -> "twenty",
    30l -> "thirty",
    40l -> "forty",
    50l -> "fifty",
    60l -> "sixty",
    70l -> "seventy",
    80l -> "eighty",
    90l -> "ninety",
    100l -> "hundred",
    1000l -> "thousand",
    1E6.toLong -> "million",
    1E9.toLong -> "billion"
  )(Ordering[Long].reverse)

  def translate(num: Long): String = {
    def findNum(curNum: Long): Option[NumberLookupType] =
      vocabulary.find { case (k, _) => k <= curNum } match {
        case Some((k, v)) => Some(curNum / k, curNum % k, k, v)
        case _ => None
      }

    def loop(curNum: Long, acc: List[NumberOfSp]): List[NumberOfSp] = {
      findNum(curNum) match {
        case None => acc.reverse
        case Some((numItems, rem, value, spelling)) => {
          val newList = (numItems, value, spelling) :: acc
          if (rem == 0) newList.reverse
          else if (value < 100) ((1l, value, spelling + "-" + vocabulary.getOrElse(rem, "")) :: acc).reverse
          else loop(rem, newList)
        }
      }
    }

    val list = loop(num, List())
    println(s"num: $num, list: $list")
    loop(num, List()).map { case (num, value, sp) =>
      println(s"num: $num, value: $value, sp: $sp")
      if (value < 100) sp
      else translate(num) + " " + sp
    }.mkString(" ")
  }

  def inEnglish(num: Long): Option[String] = {
    if (num < 0 || num > MaxVal) None
    else if (num == 0) Some("zero")
    else Some(translate(num))
  }
}
