object House5 {
  private val prefix = "This is "
  private val intToString = (inputNo: Int) => inputNo match {
    case 1 => "the house that Jack built.\n"
    case 2 => "the malt that lay in "
    case 3 => "the rat that ate "
    case 4 => "the cat that killed "
    case 5 => "the dog that worried "
    case 6 => "the cow with the crumpled horn that tossed "
    case 7 => "the maiden all forlorn that milked "
    case 8 => "the man all tattered and torn that kissed "
    case 9 => "the priest all shaven and shorn that married "
    case 10 => "the rooster that crowed in the morn that woke "
    case 11 => "the farmer sowing his corn that kept "
    case 12 => "the horse and the hound and the horn that belonged to "
    case _ => ""
  }

  private def getIntToString(end: Int) = prefix + (end to 1 by -1).map(intToString).mkString

  def recite(from: Int, end: Int): String = if (from == end) {
    getIntToString(from) + "\n"
  } else {
    getIntToString(from) + ((from + 1) to end).map(getIntToString).mkString + "\n"
  }
}