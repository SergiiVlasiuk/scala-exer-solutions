import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class RailFenceCipher6Test extends FunSuite with Matchers {

  test("encode with two rails") {
    RailFenceCipher6.encode("XOXOXOXOXOXOXOXOXO", 2) should be("XXXXXXXXXOOOOOOOOO")
  }

  test("encode with three rails") {
    RailFenceCipher6.encode("WEAREDISCOVEREDFLEEATONCE", 3) should be("WECRLTEERDSOEEFEAOCAIVDEN")
  }

  test("encode with ending in the middle") {
    RailFenceCipher6.encode("EXERCISES", 4) should be("ESXIEECSR")
  }

  test("decode with three rails") {
    RailFenceCipher6.decode("TEITELHDVLSNHDTISEIIEA", 3) should be("THEDEVILISINTHEDETAILS")
  }

  test("decode with five rails") {
    RailFenceCipher6.decode("EIEXMSMESAORIWSCE", 5) should be("EXERCISMISAWESOME")
  }

  test("decode with six rails") {
    RailFenceCipher6.decode("133714114238148966225439541018335470986172518171757571896261",
      6) should be("112358132134558914423337761098715972584418167651094617711286")
  }
}
