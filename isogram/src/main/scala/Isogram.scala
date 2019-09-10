object Isogram {
  def isIsogram(iso: String): Boolean = {
    val cleanedChars = iso.toLowerCase.filter(_.isLetter)
//    val cleanedChars = iso.replaceAll("[^A-z]", "").toLowerCase
//    println(s"$iso -> [replace all] -> " + iso.replaceAll("[^A-z]", ""))
    cleanedChars.length == cleanedChars.distinct.length
  }
}
