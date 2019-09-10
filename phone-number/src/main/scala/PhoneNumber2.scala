object PhoneNumber2 {
  private val phoneLong = """(1)([2-9]\d{2}[2-9]\d{2}\d{4})""".r
  private val phoneShort = """([2-9]\d{2}[2-9]\d{2}\d{4})""".r

  def clean(number: String): Option[String] = {
    val onlyDigits = number.replaceAll("[^0-9]", "")
    onlyDigits match {
      case phoneLong(_, onlyDigits) => Some(onlyDigits)
      case phoneShort(onlyDigits) => Some(onlyDigits)
      case _ => None
    }
  }
}


//object PhoneNumber {
//  private val phoneLong = """(1)([2-9]\d{2}[2-9]\d{2}\d{4})""".r
//  private val phoneShort = """([2-9]\d{2}[2-9]\d{2}\d{4})""".r
//
//  def clean(number: String): Option[String] = {
//    val onlyDigits = number.replaceAll("[^0-9]", "")
//    onlyDigits match {
//      case phoneLong(_, onlyDigits) => Some(onlyDigits)
//      case phoneShort(onlyDigits) => Some(onlyDigits)
//      case _ => None
//    }
//  }
//}


//object PhoneNumber2 {
//
//  val patternX = "1?((\\d{3})(\\d{3})(\\d{4}))".r
//
//  def clean(string: String): Option[String] = {
//    lazy val (number, areaCode, first, second) = string filter (_.isDigit) match {
//      case patternX(a, b, c, d) => (a, b, c, d)
//      case _ => ("0000000000", "000", "000", "0000")
//    }
//  }
//
//
//  override def toString: String = s"($areaCode) $first-$second"
//
//}
