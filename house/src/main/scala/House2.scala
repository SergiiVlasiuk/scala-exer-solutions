object House2 {
  val parts = Array[(String,String)](
    ("house", "Jack built"),
    ("malt", "lay in"),
    ("rat", "ate"),
    ("cat", "killed"),
    ("dog", "worried"),
    ("cow with the crumpled horn", "tossed"),
    ("maiden all forlorn", "milked"),
    ("man all tattered and torn", "kissed"),
    ("priest all shaven and shorn", "married"),
    ("rooster that crowed in the morn", "woke"),
    ("farmer sowing his corn", "kept"),
    ("horse and the hound and the horn", "belonged to"))

  def recite(from: Int, till: Int): String =
    (for (num <- from to till) yield recite(num - 1)).mkString + "\n"

  private def recite(num: Int): String = "This is" + build(num) + ".\n"

  private def build(num: Int): String =
    " the " + parts(num)._1 + " that " + parts(num)._2 + (if (num <= 0) "" else build(num - 1))
}