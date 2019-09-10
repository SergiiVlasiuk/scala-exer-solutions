// deep analysis
object SpiralMatrix3MyDebugging extends App {
  def spiralMatrix(rank: Int): List[List[Int]] = {
    var counter = 0
    def constructMatrix(rows: Int, columns: Int, from: Int): List[List[Int]] = {
      counter = counter + 1
//      println(s"rows: $rows, columns: $columns, from: $from")
      if (rows == 0){
        println(s"rows: $rows, columns: $columns, from: $from, iteration <$counter>, method constructs and awaits for recursion result <${List.empty}>")
        List.empty
      }
//      else (from until from + columns).toList :: constructMatrix(columns, rows - 1, from + columns).reverse
      else {
        val list = (from until from + columns).toList
        println(s"rows: $rows, columns: $columns, from: $from, iteration <$counter>, method constructs and awaits for recursion result <$list>")
//        println(s"returns <$list>")
        val result = list :: constructMatrix(columns, rows - 1, from + columns).reverse.transpose
        println(s"method returns <$result>")
        result
      }
    }

    constructMatrix(rank, rank, 1)
  }

  println("List.empty.reverse.transpose\t//\t" + List.empty.reverse.transpose)
  println("\nList(9)::(List.empty::List.empty.reverse.transpose)\t//\t" + List(9):: (List.empty::List.empty.reverse.transpose))
  val single = List(List(9))
  println("single\t//\t" + single)
  println("single.transpose\t//\t" + single.transpose)
  println("single.reverse\t//\t" + single.reverse)
  println("single.reverse.transpose\t//\t" + single.reverse.transpose)
  val xs = List(List(4, 5), List(6, 7), List(8, 9))
  println("xs\t//\t" + xs)
  println("xs.transpose\t//\t" + xs.transpose)
  println("xs.reverse\t//\t" + xs.reverse)
  println("xs.reverse.transpose\t//\t" + xs.reverse.transpose)
  //  println(spiralMatrix(3))

  val x = Set(Set(8), Set(9))
  println("x\t//\t" + x)
  println("x.reverse\t//\t" + x.toList.reverse)
  println("x.transpose\t//\t" + x.transpose)
  println("x.reverse.transpose:" + x.toList.reverse.transpose)
  println("x.transpose.transpose\t//\t" + x.transpose.transpose)
  println("x.reverse.transpose.transpose\t//\t" + x.toList.reverse.transpose.transpose)
  println("List(40, 45, 46)::xs\t//\t" + List(40, 45, 46)::xs) // => List(List(40, 45, 46), List(4, 5), List(6, 7), List(8, 9))
  println("List(40, 45, 46)::xs.transpose\t//\t" + List(40, 45, 46)::xs.transpose) // => List(List(40, 45, 46), List(4, 6, 8), List(5, 7, 9))
}
