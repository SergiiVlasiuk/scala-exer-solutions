import scala.util.Random

case class Cipher9(opt: Option[String]) {
  val key = opt match {
    case None => (for(i <- 1 to 150) yield  Random.nextPrintableChar).filter(c => c >= 'a' && c <= 'z').mkString
    case Some(opt) => if (opt.isEmpty || opt.exists(c => c.isDigit || c.isUpper)) throw new IllegalArgumentException else opt
  }

  def encode(mess:String): String = (key zip mess).map { case (i,j) => ((i - 97) + (j - 97)) % 26 + 97 }.map(c => c.toChar).mkString

  def decode(data: String): String =  (data zip key).map { case (i,j) => i - j + 97 }.map(c => c.toChar).mkString
}
