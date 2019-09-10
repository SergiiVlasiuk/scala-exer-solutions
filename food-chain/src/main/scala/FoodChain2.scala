trait Creature {
  def name: String
}
object Fly extends Creature {
  def name: String = "fly"
}
object Spider extends Creature {
  def name: String = "spider"
}
object Bird extends Creature {
  def name: String = "bird"
}
object Cat extends Creature {
  def name: String = "cat"
}
object Dog extends Creature {
  def name: String = "dog"
}
object Goat extends Creature {
  def name: String = "goat"
}
object Cow extends Creature {
  def name: String = "cow"
}
object Horse extends Creature {
  def name: String = "horse"
}

object FoodChain2 {
  private val swallowSeq: Seq[Creature] = Seq(Fly, Spider, Bird, Cat, Dog, Goat, Cow, Horse)

  def uniqueVerse(creature: Creature): String = creature match {
    case Fly => "I don't know why she swallowed the fly. Perhaps she'll die."
    case Spider => "It wriggled and jiggled and tickled inside her."
    case Bird => "How absurd to swallow a bird!"
    case Cat => "Imagine that, to swallow a cat!"
    case Dog => "What a hog, to swallow a dog!"
    case Goat => "Just opened her throat and swallowed a goat!"
    case Cow => "I don't know how she swallowed a cow!"
    case Horse => "She's dead, of course!"
  }

  def sequentiallySwallowedVerse(swallowedCreature: Creature, aimedToCaughtCreature: Creature): String =
    (swallowedCreature, aimedToCaughtCreature) match {
      case (Bird, Spider) => s"She swallowed the ${Bird.name} to catch the ${Spider.name} that wriggled and jiggled and tickled inside her."
      case _ => s"She swallowed the ${swallowedCreature.name} to catch the ${aimedToCaughtCreature.name}."
    }

  def composeVerses(composed: List[String], restCreatures: Seq[Creature]): List[String] = (composed, restCreatures) match {
    case (_, Nil) => composed
    case (Nil, firstCreature :: creatures) => composeVerses(
      List(s"I know an old lady who swallowed a ${firstCreature.name}.", uniqueVerse(firstCreature)),
      if (creatures.isEmpty || firstCreature == Horse) Nil else restCreatures
    )
    case (_, creature :: Nil) => composed :+ uniqueVerse(creature)
    case (_, swallowedCreature :: aimedToCaughtCreature :: creatures) => composeVerses(
      composed :+ sequentiallySwallowedVerse(swallowedCreature, aimedToCaughtCreature),
      aimedToCaughtCreature +: creatures
    )
  }


  def recite(start: Int, end: Int): String = {
    (start-1 until end).flatMap { idx =>
      composeVerses(Nil, swallowSeq.slice(0, idx + 1).reverse).mkString("\n") ++ "\n\n"
    }.mkString
  }
}