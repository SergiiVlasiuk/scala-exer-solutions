object Series4 {
  def largestProduct(product: Int, digits: String): Option[Int] = product match {
    case 0 => Some(1)
    case _ if digits.isEmpty || digits.exists(!_.isDigit) || product < 0 || product > digits.size => None
    case _ => Some(digits.map(_.asDigit).sliding(product).map(_.product).max)
  }
}
