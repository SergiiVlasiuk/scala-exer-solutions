object Pangrams {
  def isPangram(input: String): Boolean = {
    val lowerCase = input.toLowerCase
    ('a' to 'z').forall {
      lowerCase.contains(_)
    }
  }
}

