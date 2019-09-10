import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class RnaTranscription3Test extends FunSuite with Matchers {

  test("RNA complement of cytosine is guanine") {
    RnaTranscription3.toRna("C") should be(Some("G"))
  }

  test("RNA complement of guanine is cytosine") {
    RnaTranscription3.toRna("G") should be(Some("C"))
  }

  test("RNA complement of thymine is adenine") {
    RnaTranscription3.toRna("T") should be(Some("A"))
  }

  test("RNA complement of adenine is uracil") {
    RnaTranscription3.toRna("A") should be(Some("U"))
  }

  test("RNA complement") {
    RnaTranscription3.toRna("ACGTGGTCTTAA") should be(Some("UGCACCAGAAUU"))
  }

}
