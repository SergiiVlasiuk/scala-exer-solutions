object Etl {
  def transform(intToStrings: Map[Int, Seq[String]]): Map[String, Int] = {
    intToStrings.flatMap { case (number, letters) =>
//      letters.map { letter => letter.toLowerCase -> number }
      letters.map( letter => letter.toLowerCase -> number )
    }
  }
}
