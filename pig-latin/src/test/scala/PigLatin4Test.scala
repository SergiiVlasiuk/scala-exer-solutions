import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class PigLatin4Test extends FunSuite with Matchers {

  test("word beginning with a") {
    PigLatin4.translate("apple") should be("appleay")
  }

  test("word beginning with e") {
    PigLatin4.translate("ear") should be("earay")
  }

  test("word beginning with i") {
    PigLatin4.translate("igloo") should be("iglooay")
  }

  test("word beginning with o") {
    PigLatin4.translate("object") should be("objectay")
  }

  test("word beginning with u") {
    PigLatin4.translate("under") should be("underay")
  }

  test("word beginning with a vowel and followed by a qu") {
    PigLatin4.translate("equal") should be("equalay")
  }

  test("word beginning with p") {
    PigLatin4.translate("pig") should be("igpay")
  }

  test("word beginning with k") {
    PigLatin4.translate("koala") should be("oalakay")
  }

  test("word beginning with x") {
    PigLatin4.translate("xenon") should be("enonxay")
  }

  test("word beginning with q without a following u") {
    PigLatin4.translate("qat") should be("atqay")
  }

  test("word beginning with ch") {
    PigLatin4.translate("chair") should be("airchay")
  }

  test("word beginning with qu") {
    PigLatin4.translate("queen") should be("eenquay")
  }

  test("word beginning with qu and a preceding consonant") {
    PigLatin4.translate("square") should be("aresquay")
  }

  test("word beginning with th") {
    PigLatin4.translate("therapy") should be("erapythay")
  }

  test("word beginning with thr") {
    PigLatin4.translate("thrush") should be("ushthray")
  }

  test("word beginning with sch") {
    PigLatin4.translate("school") should be("oolschay")
  }

  test("word beginning with yt") {
    PigLatin4.translate("yttria") should be("yttriaay")
  }

  test("word beginning with xr") {
    PigLatin4.translate("xray") should be("xrayay")
  }

  test("y is treated like a consonant at the beginning of a word") {
    PigLatin4.translate("yellow") should be("ellowyay")
  }

  test("y is treated like a vowel at the end of a consonant cluster") {
    PigLatin4.translate("rhythm") should be("ythmrhay")
  }

  test("y as second letter in two letter word") {
    PigLatin4.translate("my") should be("ymay")
  }

  test("a whole phrase") {
    PigLatin4.translate("quick fast run") should be("ickquay astfay unray")
  }
}
