object SecretHandshake {
  val secrets: Map[Int, String] = Map(
    1 -> "wink",
    2 -> "double blink",
    4 -> "close your eyes",
    8 -> "jump"
  )

  val reverse: Int = 16

  def commands(input: Int): List[String] = {
    val list = secrets.foldLeft(List[String]())((acc, pair) =>
      if ((input & pair._1) > 0) pair._2 :: acc
      else acc
    )
    println(s"input & reverse =>  $input & $reverse = " + (input & reverse))
    if ((input & reverse) > 0) list
    else list.reverse
  }
}
