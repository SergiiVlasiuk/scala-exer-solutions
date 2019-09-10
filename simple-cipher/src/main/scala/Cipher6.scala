import scala.util.Random

/**
  * Created by qyu on 17. 5. 16.
  */
case class Cipher6(op: Option[String]) {
  val key = op match {
    case Some(key)  => require(key.forall(_.isLower) && !key.isEmpty); key  //  invalid key test
    case None       => new Random(10).alphanumeric.filter(_.isLower).take(128).mkString // random key cipher
  }

  val table = 'a' to 'z' // table to find cipher or plain text

  // -a to get index of plain text & key in table
  // %26 to scale index into table length
  def encode(plain : String): String = {
    (plain zip key).map { case (p, k) =>
      table((p + k - 2 * 'a') % 26)
    }.mkString
  }

  //decode is engine like reverse-encode
  // (c-'a') - (k-'a') == c - k
  def decode(cipher: String): String = {
    (cipher zip key).map{case (c, k) =>
      table((c - k + 26) % 26)
    }.mkString
  }
}