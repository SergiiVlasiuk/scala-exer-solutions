object BeerSong2 {
  def recite(start: Int, nVerses: Int): String = (start until start-nVerses by -1).map(verse).mkString("\n")

  def verse(n: Int): String = {
    println(s"n: $n")
    n match {
      case 0 => s"No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, ${bottles_on_the_wall(99)}.\n"
      case 1 => "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"
      case 2 => s"${bottles_on_the_wall(2)}, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"
      case _ => s"${bottles_on_the_wall(n)}, $n bottles of beer.\nTake one down and pass it around, ${bottles_on_the_wall(n-1)}.\n"
    }
  }

  def bottles_on_the_wall(n: Int): String = s"$n bottles of beer on the wall"

}
