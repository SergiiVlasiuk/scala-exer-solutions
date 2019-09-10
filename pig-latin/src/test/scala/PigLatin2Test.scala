import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class PigLatin2Test extends FunSuite with Matchers {

  test("word beginning with a") {
    PigLatin2.translate("apple") should be("appleay")
  }

  test("word beginning with e") {
    PigLatin2.translate("ear") should be("earay")
  }

  test("word beginning with i") {
    PigLatin2.translate("igloo") should be("iglooay")
  }

  test("word beginning with o") {
    PigLatin2.translate("object") should be("objectay")
  }

  test("word beginning with u") {
    PigLatin2.translate("under") should be("underay")
  }

  test("word beginning with a vowel and followed by a qu") {
    PigLatin2.translate("equal") should be("equalay")
  }

  test("word beginning with p") {
    PigLatin2.translate("pig") should be("igpay")
  }

  test("word beginning with k") {
    PigLatin2.translate("koala") should be("oalakay")
  }

  test("word beginning with x") {
    PigLatin2.translate("xenon") should be("enonxay")
  }

  test("word beginning with q without a following u") {
    PigLatin2.translate("qat") should be("atqay")
  }

  test("word beginning with ch") {
    PigLatin2.translate("chair") should be("airchay")
  }

  test("word beginning with qu") {
    PigLatin2.translate("queen") should be("eenquay")
  }

  test("word beginning with qu and a preceding consonant") {
    PigLatin2.translate("square") should be("aresquay")
  }

  test("word beginning with th") {
    PigLatin2.translate("therapy") should be("erapythay")
  }

  test("word beginning with thr") {
    PigLatin2.translate("thrush") should be("ushthray")
  }

  test("word beginning with sch") {
    PigLatin2.translate("school") should be("oolschay")
  }

  test("word beginning with yt") {
    PigLatin2.translate("yttria") should be("yttriaay")
  }

  test("word beginning with xr") {
    PigLatin2.translate("xray") should be("xrayay")
  }

  test("y is treated like a consonant at the beginning of a word") {
    PigLatin2.translate("yellow") should be("ellowyay")
  }

  test("y is treated like a vowel at the end of a consonant cluster") {
    PigLatin2.translate("rhythm") should be("ythmrhay")
  }

  test("y as second letter in two letter word") {
    PigLatin2.translate("my") should be("ymay")
  }

  test("a whole phrase") {
    PigLatin2.translate("quick fast run") should be("ickquay astfay unray")
  }
}
