object PhoneNumber {
  private val validNum = "1?([2-9][0-9]{2}[2-9][0-9]{6})".r

  def clean(number:String):Option[String] = {
    number filter(_.isDigit) match {
      case validNum(number) => Some(number)
      case _ => None
    }
  }
}

//Note: jadermcs's solution.