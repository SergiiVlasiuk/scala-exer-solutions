import scala.annotation.tailrec

object Wordy7 {
  private def notValue: String => Boolean = !_.matches("^-?\\d+")

  @tailrec
  private def compile(current: Option[BigInt], parts: List[String]): Option[BigInt] =
    parts.span(notValue) match {
      case (List("what", "is"),          value :: xs) => compile(Some(BigInt(value)), xs)
      case (List("plus"),                value :: xs) => compile(current.map(_ + BigInt(value)), xs)
      case (List("minus"),               value :: xs) => compile(current.map(_ - BigInt(value)), xs)
      case (List("divided", "by"),       value :: xs) => compile(current.map(_ / BigInt(value)), xs)
      case (List("multiplied", "by"),    value :: xs) => compile(current.map(_ * BigInt(value)), xs)
      case (List("raised", "to", "the"), value :: xs) => compile(current.map(_ pow value.toInt), xs)
      case (_,                           Nil        ) => current
      // in case of unknown operation returns None
      case _ => None
    }

  def answer(expression: String) =
    compile(None, expression.toLowerCase.split("[^\\w|^-]+").toList)
}