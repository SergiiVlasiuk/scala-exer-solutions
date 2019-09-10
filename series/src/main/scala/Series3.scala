import scala.annotation.tailrec
object Series3 {
  def slices(slices: Int, series: String): List[Seq[Int]] = series.map(_.asDigit).sliding(slices).toList

  def slicesNaive(slices: Int, series: String): List[List[Int]] = {
    @tailrec def go(acc: List[List[Int]], series: String): List[List[Int]] = series.size match {
      case size if size < slices => acc
      case s => go(series.take(slices).toList.map(_.asDigit) :: acc, series.drop(1))
    }
    go(List.empty, series).reverse
  }
}