case class Bowling2(rolls: Seq[Int] = Seq()) {
  def roll(pins: Int): Bowling2 = copy(rolls = rolls :+ pins)

  def score(): Either[String, Int] = {
    if (rolls.exists(_ < 0)) Left("pins < 0")
    else if (rolls.exists(_ > 10)) Left("pins > 10")
    else {
      def loop(rolls: Seq[Int], score: Int = 0, frame: Int = 1): Either[String, Int] =
        if (rolls.isEmpty) Left("Game not even started! :(")
        else if (frame == 10) rolls match {
          case Seq(10, 10, c) => Right(score + 10 + 10 + c)
          case Seq(10, 10) => Left("10th frame missing bonus roll!")
          case Seq(10, b, c) if (b + c > 10) => Left("10th frame cannot score > 10 for bonus rolls!")
          case Seq(10, b, c) => Right(score + 10 + b + c)
          case Seq(a, b, c) if (a + b == 10) => Right(score + 10 + c)
          case Seq(a, b) if (a + b == 10) => Left("10th frame missing bonus roll!")
          case Seq(a, b) => Right(score + a + b)
          case _ => Left("10th frame missing rolls! Game not done?")
        } else rolls match {
          case Seq(10, b, c, _*) => loop(rolls.drop(1), score + 10 + b + c, frame + 1)
          case Seq(a, b, c, _*) if (a + b == 10) => loop(rolls.drop(2), score + 10 + c, frame + 1)
          case Seq(a, b, _*) if (a + b > 10) => Left(s"Cannot score > 10 in a frame! $frame")
          case Seq(a, b, _*) => loop(rolls.drop(2), score + a + b, frame + 1)
          case _ => Left(s"Missing rolls! Game not done? $frame")
        }

      loop(rolls)
    }
  }
}
