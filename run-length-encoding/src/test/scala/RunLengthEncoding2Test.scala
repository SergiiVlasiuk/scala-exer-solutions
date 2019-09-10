import org.scalatest.{FunSuite, Matchers}

/** @version 1.0.0 */
class RunLengthEncoding2Test extends FunSuite with Matchers {

  test("encode - empty string") {
    RunLengthEncoding2.encode("") should be("")
  }

  test("encode - single characters only are encoded without count") {
    RunLengthEncoding2.encode("XYZ") should be("XYZ")
  }

  test("encode - string with no single characters") {
    RunLengthEncoding2.encode("AABBBCCCC") should be("2A3B4C")
  }

  test("encode - single characters mixed with repeated characters") {
    RunLengthEncoding2.encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB") should be("12WB12W3B24WB")
  }

  test("encode - multiple whitespace mixed in string") {
    RunLengthEncoding2.encode("  hsqq qww  ") should be("2 hs2q q2w2 ")
  }

  test("encode - lowercase characters") {
    RunLengthEncoding2.encode("aabbbcccc") should be("2a3b4c")
  }

  test("decode - empty string") {
    RunLengthEncoding2.decode("") should be("")
  }

  test("decode - single characters only") {
    RunLengthEncoding2.decode("XYZ") should be("XYZ")
  }

  test("decode - string with no single characters") {
    RunLengthEncoding2.decode("2A3B4C") should be("AABBBCCCC")
  }

  test("decode - single characters with repeated characters") {
    RunLengthEncoding2.decode("12WB12W3B24WB") should be("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB")
  }

  test("decode - multiple whitespace mixed in string") {
    RunLengthEncoding2.decode("2 hs2q q2w2 ") should be("  hsqq qww  ")
  }

  test("decode - lower case string") {
    RunLengthEncoding2.decode("2a3b4c") should be("aabbbcccc")
  }

  test("consistency - encode followed by decode gives original string") {
    RunLengthEncoding2.decode(RunLengthEncoding2.encode("zzz ZZ  zZ")) should be("zzz ZZ  zZ")
  }
}