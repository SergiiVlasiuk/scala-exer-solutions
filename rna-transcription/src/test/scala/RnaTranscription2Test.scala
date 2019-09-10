import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class RnaTranscription2Test extends FunSuite with Matchers {

  test("RNA complement of cytosine is guanine") {
    RnaTranscription2.toRna("C") should be(Some("G"))
  }

  test("RNA complement of guanine is cytosine") {
    RnaTranscription2.toRna("G") should be(Some("C"))
  }

  test("RNA complement of thymine is adenine") {
    RnaTranscription2.toRna("T") should be(Some("A"))
  }

  test("RNA complement of adenine is uracil") {
    RnaTranscription2.toRna("A") should be(Some("U"))
  }

  test("RNA complement") {
    RnaTranscription2.toRna("ACGTGGTCTTAA") should be(Some("UGCACCAGAAUU"))
  }

//  test("RNA complement of empty string") {
//    RnaTranscription2.toRna("") should be(None)
//  }
}
