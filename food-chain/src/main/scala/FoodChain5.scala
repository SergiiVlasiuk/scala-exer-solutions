object FoodChain5 {
  sealed trait Stanza {
    def name: String
    def catched: Option[Stanza] = None
    def dedicate: Option[String] = None
    def sing: String =
      Seq(Option(s"I know an old lady who swallowed a $name."),
        dedicate,
        swallowing,
        Option(""))
        .filterNot(_.isEmpty)
        .map(_.get)
        .mkString("\n")

    def swallowing: Option[String] =
      catched.map(stanza =>
        s"""She swallowed the ${name} to catch the ${stanza.name}.
           |${stanza.swallowing.get}""".stripMargin)
        .orElse(Option("I don't know why she swallowed the fly. Perhaps she'll die."))
  }

  case object Fly extends Stanza {
    def name = "fly"
  }

  case object Spider extends Stanza {
    def name = "spider"
    override def dedicate = Option("It wriggled and jiggled and tickled inside her.")
    override def catched = Some(Fly)
  }

  case object Bird extends Stanza {
    def name = "bird"
    override def dedicate = Option("How absurd to swallow a bird!")
    override def catched = Some(Spider)
    override def swallowing =
      catched.map(stanza =>
        s"""She swallowed the ${name} to catch the ${stanza.name} that wriggled and jiggled and tickled inside her.
           |${stanza.swallowing.get}""".stripMargin)
  }

  case object Cat extends Stanza {
    def name = "cat"
    override def dedicate = Option("Imagine that, to swallow a cat!")
    override def catched = Some(Bird)
  }

  case object Dog extends Stanza {
    def name = "dog"
    override def dedicate = Option("What a hog, to swallow a dog!")
    override def catched = Some(Cat)
  }

  case object Goat extends Stanza {
    def name = "goat"
    override def dedicate = Option("Just opened her throat and swallowed a goat!")
    override def catched = Some(Dog)
  }

  case object Cow extends Stanza {
    def name = "cow"
    override def dedicate = Option("I don't know how she swallowed a cow!")
    override def catched = Some(Goat)
  }

  case object Horse extends Stanza {
    def name = "horse"
    override def dedicate = Option("She's dead, of course!")
    override def swallowing = None
  }

  val Song = Seq(Fly, Spider, Bird, Cat, Dog, Goat, Cow, Horse)

  lazy val song =
    Song
      .map(_.sing)
      .mkString("\n") + "\n"

}