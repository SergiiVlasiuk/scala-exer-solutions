object Anagram2 {
  def findAnagrams(word: String, examples: List[String]) =
    examples.filter(it => word.toLowerCase != it.toLowerCase && base(word).sameElements(base(it)))

  private def base(w: String) = w.toLowerCase.toCharArray.sorted

}
