import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class AtbashCipher2Test extends FunSuite with Matchers {
  test("encode yes") {
    AtbashCipher2.encode("yes") should be("bvh")
  }

  test("encode no") {
    AtbashCipher2.encode("no") should be("ml")
  }

  test("encode OMG") {
    AtbashCipher2.encode("OMG") should be("lnt")
  }

  test("encode spaces") {
    AtbashCipher2.encode("O M G") should be("lnt")
  }

  test("encode mindblowingly") {
    AtbashCipher2.encode("mindblowingly") should be("nrmwy oldrm tob")
  }

  test("encode numbers") {
    AtbashCipher2.encode("Testing,1 2 3, testing.") should be("gvhgr mt123 gvhgr mt")
  }

  test("encode deep thought") {
    AtbashCipher2.encode("Truth is fiction.") should be("gifgs rhurx grlm")
  }

  test("encode all the letters") {
    AtbashCipher2.encode("The quick brown fox jumps over the lazy dog.") should be(
      "gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt")
  }

  test("decode exercism") {
    AtbashCipher2.decode("vcvix rhn") should be("exercism")
  }

  test("decode a sentence") {
    AtbashCipher2.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v") should be("anobstacleisoftenasteppingstone")
  }

  test("decode numbers") {
    AtbashCipher2.decode("gvhgr mt123 gvhgr mt") should be("testing123testing")
  }

  test("decode all the letters") {
    AtbashCipher2.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt") should be(
      "thequickbrownfoxjumpsoverthelazydog")
  }

  test("decode with too many spaces") {
    AtbashCipher2.decode("vc vix    r hn") should be("exercism")
  }

  test("decode with no spaces") {
    AtbashCipher2.decode("zmlyhgzxovrhlugvmzhgvkkrmthglmv") should be("anobstacleisoftenasteppingstone")
  }
}
