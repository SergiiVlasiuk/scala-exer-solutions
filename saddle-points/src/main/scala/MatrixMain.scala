object MatrixMain {
  def main(args: Array[String]) {
    var a = 0;

    // for loop execution with a range
    for( a <- 1 to 10){
      println( "Value of a: " + a );
    }

    val list = List(List(9, 8, 7), List(5, 3, 2), List(6, 6, 7))

//    val saddlePoints: Set[(Int, Int)] = (for {
//      r <- list.indices
//      c <- list.head.indices
//      t = list.transpose
//      if list(r).max == list(r)(c) && t(c).min == list(r)(c)
//    } yield (r, c)).toSet
    val saddlePoints: Iterable[(Int, Int)] = (for {
      r <- list.indices
//      r => list.indices
      c <- list.head.indices
      t = list.transpose
//      if list(r).max == list(r)(c) && t(c).min == list(r)(c)
    } yield (r, c)).toList
    println(s"saddlePoints: $saddlePoints")
  }
}
