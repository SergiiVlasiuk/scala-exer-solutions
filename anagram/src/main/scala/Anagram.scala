object Anagram {
  def findAnagrams(input: String, candidates: List[String]): List[String] = {
    val word: String = input.sortBy(_.toLower)
    candidates.filterNot(_ equalsIgnoreCase input)
      .filter(_.sortBy(_.toLower) equalsIgnoreCase word)
  }

}
