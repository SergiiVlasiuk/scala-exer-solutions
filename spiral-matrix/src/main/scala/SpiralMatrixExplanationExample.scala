import scala.annotation.tailrec

object SpiralMatrixExplanationExample extends App {

  // see SpiralMatrix3
  //
  // online scala repl:
  // https://scastie.scala-lang.org/blrez4GOQdW1jNTHbyp0Yw


  println("List(8)::List(9) " + (List(8)::List(9)))
  println("List(8)::List(List(9)) => " + (List(8)::List(List(9))))
  println("empty list " + List())
  println("empty list .reverse.transpose " + List().reverse.transpose)
  println("========================================================================")

  var l: List[List[Any]] = List.empty::List.empty
  println(s"$l = List.empty::List.empty")
  println(s".                             \t\t\t$l.reverse.transpose => " + l.reverse.transpose)
  l = List(9) :: l.reverse.transpose
  println(s"$l = List(9) :: l.reverse.transpose")
  println(s".                             \t\t\t$l.reverse.transpose => " + l.reverse.transpose)
  l = List(8) :: l.reverse.transpose
  println(s"$l = List(8) :: l.reverse.transpose")
  println(s".                             \t\t\t$l.reverse.transpose => " + l.reverse.transpose)
  l = List(6,7) :: l.reverse.transpose
  println(s"$l = List(6,7) :: l.reverse.transpose")
  println(s".                             \t\t\t$l.reverse.transpose => " + l.reverse.transpose)
  l = List(4,5) :: l.reverse.transpose
  println(s"$l = List(4,5) :: l.reverse.transpose")
  println(s".                             \t\t\t$l.reverse.transpose => " + l.reverse.transpose)
  l = List(1,2,3) :: l.reverse.transpose
  println(s"$l = List(1,2,3) :: l.reverse.transpose")
}
