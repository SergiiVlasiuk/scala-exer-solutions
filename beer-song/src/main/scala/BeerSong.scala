object BeerSong {
  def recite(start: Int, toBeDrunk: Int): String =
    (start until start - toBeDrunk by -1).map(makeGreaterIfRequired andThen repeatableText).mkString("\n")

  private def repeatableText: Int => String =
    bottles => s"${remainingBottles(bottles)} of beer on the wall, ${remainingBottles(bottles).toLowerCase} of beer.\n${action(bottles)}, ${remainingBottles(bottles - 1).toLowerCase} of beer on the wall.\n"

  private def remainingBottles: Int => String = {
    case 1 => "1 bottle"
    case 0 => "No more bottles"
    case -1 => "99 bottles"
    case bottles: Int => s"$bottles bottles"
  }

  private def action: Int => String = {
    case 1 => "Take it down and pass it around"
    case 0 => "Go to the store and buy some more"
    case _ => "Take one down and pass it around"
  }

  private def makeGreaterIfRequired: Int => Int = {
    case count if (count < 0) => 100 + count % 100
    case count => count
  }
}