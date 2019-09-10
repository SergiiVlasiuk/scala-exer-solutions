import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class PigLatin5Test extends FunSuite with Matchers {

  test("word beginning with a") {
    PigLatin5.translate("apple") should be("appleay")
  }

  test("word beginning with e") {
    PigLatin5.translate("ear") should be("earay")
  }

  test("word beginning with i") {
    PigLatin5.translate("igloo") should be("iglooay")
  }

  test("word beginning with o") {
    PigLatin5.translate("object") should be("objectay")
  }

  test("word beginning with u") {
    PigLatin5.translate("under") should be("underay")
  }

  test("word beginning with a vowel and followed by a qu") {
    PigLatin5.translate("equal") should be("equalay")
  }

  test("word beginning with p") {
    PigLatin5.translate("pig") should be("igpay")
  }

  test("word beginning with k") {
    PigLatin5.translate("koala") should be("oalakay")
  }

  test("word beginning with x") {
    PigLatin5.translate("xenon") should be("enonxay")
  }

  test("word beginning with q without a following u") {
    PigLatin5.translate("qat") should be("atqay")
  }

  test("word beginning with ch") {
    PigLatin5.translate("chair") should be("airchay")
  }

  test("word beginning with qu") {
    PigLatin5.translate("queen") should be("eenquay")
  }

  test("word beginning with qu and a preceding consonant") {
    PigLatin5.translate("square") should be("aresquay")
  }

  test("word beginning with th") {
    PigLatin5.translate("therapy") should be("erapythay")
  }

  test("word beginning with thr") {
    PigLatin5.translate("thrush") should be("ushthray")
  }

  test("word beginning with sch") {
    PigLatin5.translate("school") should be("oolschay")
  }

  test("word beginning with yt") {
    PigLatin5.translate("yttria") should be("yttriaay")
  }

  test("word beginning with xr") {
    PigLatin5.translate("xray") should be("xrayay")
  }

  test("y is treated like a consonant at the beginning of a word") {
    PigLatin5.translate("yellow") should be("ellowyay")
  }

  test("y is treated like a vowel at the end of a consonant cluster") {
    PigLatin5.translate("rhythm") should be("ythmrhay")
  }

  test("y as second letter in two letter word") {
    PigLatin5.translate("my") should be("ymay")
  }

  test("a whole phrase") {
    PigLatin5.translate("quick fast run") should be("ickquay astfay unray")
  }
}
