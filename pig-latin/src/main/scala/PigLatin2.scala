import scala.annotation.tailrec

object PigLatin2 {
  private val vowel = Seq('a', 'e', 'i', 'o', 'u')

  def translate(s: String): String = s.split(" ").map(translateWord).mkString(" ")

//  @tailrec
  def translateWord(s: String): String = ???
//  def translateWord(s: String): String = {
//    s.toList match {
//      case 'q'::'u'::xs                 => translateWord(xs.mkString + "qu")
//      case x::xs if (vowel.contains(x)) => s + "ay"
//      case x::xs                        => translateWord(xs.mkString + x.toString)
//    }
//  }
}