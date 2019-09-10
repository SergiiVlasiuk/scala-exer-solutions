import scala.collection.mutable

object Strain3 {
  def keep[T](input: Seq[T], callback: (T) => Boolean): List[T] = {
    val output = new mutable.MutableList[T]

    input.foreach { x =>
      if (callback(x)) {
        output += x
      }
    }

    output.toList
  }

  def discard[T](input: Seq[T], callback: (T) => Boolean): List[T] = Strain3.keep(input, (x: T) => !callback(x))
}