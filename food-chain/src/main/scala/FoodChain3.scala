object FoodChain3 {
  val builders: Array[Build] = Array(new FirstLine, new PhraseLine, new NextLine)
  val what: Rhyme => String = _.swallowed + "."

  val fly: Rhyme = new FlyVerse
  val spider: Verse = new Verse(
    "spider",
    "It wriggled and jiggled and tickled inside her.",
    builders,
    verse => s"${verse.swallowed} ${verse.phrase.replaceAll("It", "that")}",
    fly)

  val bird: Verse = new Verse(
    "bird",
    "How absurd to swallow a bird!",
    builders,
    what,
    spider)

  val cat: Verse = new Verse(
    "cat",
    "Imagine that, to swallow a cat!",
    builders,
    what,
    bird)

  val dog: Verse = new Verse(
    "dog",
    "What a hog, to swallow a dog!",
    builders,
    what,
    cat)

  val goat: Verse = new Verse(
    "goat",
    "Just opened her throat and swallowed a goat!",
    builders,
    what,
    dog)

  val cow: Verse = new Verse(
    "cow",
    "I don't know how she swallowed a cow!",
    builders,
    what,
    goat)

  val horse: Rhyme = new HorseVerse

  def recite(start: Int, end: Int): String =
    if (start <= end) choose(start) + "\n" + recite(start+1, end)
    else ""

  private def choose(choice: Int): String = choice match {
    case 1 => fly.build
    case 2 => spider.build
    case 3 => bird.build
    case 4 => cat.build
    case 5 => dog.build
    case 6 => goat.build
    case 7 => cow.build
    case 8 => horse.build
  }
}

class Verse(
             val swallowed: String,
             val phrase: String,
             val builders: Array[Build],
             what: Rhyme => String,
             nextVerse: Rhyme) extends Rhyme {

  override def whatItIs: String = what(this)
  override def nextLine: String = s"She swallowed the $swallowed to catch the ${nextVerse.whatItIs}\n${nextVerse.nextLine}"
}

class FlyVerse extends Rhyme {
  override val swallowed: String = "fly"
  override val phrase: String = ""
  override val builders: Array[Build] = Array(new FirstLine, new NextLine)
  override def whatItIs: String = swallowed + "."
  override def nextLine: String = "I don't know why she swallowed the fly. Perhaps she'll die."
}

class HorseVerse extends Rhyme {
  override val swallowed: String = "horse"
  override val phrase: String = ""
  override val builders: Array[Build] = Array(new FirstLine, new NextLine)
  override def whatItIs: String = ""
  override def nextLine: String = "She's dead, of course!"
}

class FirstLine extends Build {
  override def build(rhyme: Rhyme): String = s"I know an old lady who swallowed a ${rhyme.swallowed}.\n"
}

class PhraseLine extends Build {
  override def build(rhyme: Rhyme): String = s"${rhyme.phrase}\n"
}

class NextLine extends Build {
  override def build(rhyme: Rhyme): String = s"${rhyme.nextLine}\n"
}

trait Build {
  def build(rhyme: Rhyme): String
}

trait Rhyme {
  val swallowed: String
  val phrase: String
  val builders: Array[Build]
  def whatItIs: String
  def nextLine: String
  def build: String = builders.map(b => b.build(this)).reduceLeft(_+_)
}