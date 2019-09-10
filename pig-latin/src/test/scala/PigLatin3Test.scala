import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class PigLatin3Test extends FunSuite with Matchers {

  test("word beginning with a") {
    PigLatin3.translate("apple") should be("appleay")
  }

  test("word beginning with e") {
    PigLatin3.translate("ear") should be("earay")
  }

  test("word beginning with i") {
    PigLatin3.translate("igloo") should be("iglooay")
  }

  test("word beginning with o") {
    PigLatin3.translate("object") should be("objectay")
  }

  test("word beginning with u") {
    PigLatin3.translate("under") should be("underay")
  }

  test("word beginning with a vowel and followed by a qu") {
    PigLatin3.translate("equal") should be("equalay")
  }

  test("word beginning with p") {
    PigLatin3.translate("pig") should be("igpay")
  }

  test("word beginning with k") {
    PigLatin3.translate("koala") should be("oalakay")
  }

  test("word beginning with x") {
    PigLatin3.translate("xenon") should be("enonxay")
  }

  test("word beginning with q without a following u") {
    PigLatin3.translate("qat") should be("atqay")
  }

  test("word beginning with ch") {
    PigLatin3.translate("chair") should be("airchay")
  }

  test("word beginning with qu") {
    PigLatin3.translate("queen") should be("eenquay")
  }

  test("word beginning with qu and a preceding consonant") {
    PigLatin3.translate("square") should be("aresquay")
  }

  test("word beginning with th") {
    PigLatin3.translate("therapy") should be("erapythay")
  }

  test("word beginning with thr") {
    PigLatin3.translate("thrush") should be("ushthray")
  }

  test("word beginning with sch") {
    PigLatin3.translate("school") should be("oolschay")
  }

  test("word beginning with yt") {
    PigLatin3.translate("yttria") should be("yttriaay")
  }

  test("word beginning with xr") {
    PigLatin3.translate("xray") should be("xrayay")
  }

  test("y is treated like a consonant at the beginning of a word") {
    PigLatin3.translate("yellow") should be("ellowyay")
  }

  test("y is treated like a vowel at the end of a consonant cluster") {
    PigLatin3.translate("rhythm") should be("ythmrhay")
  }

  test("y as second letter in two letter word") {
    PigLatin3.translate("my") should be("ymay")
  }

  test("a whole phrase") {
    PigLatin3.translate("quick fast run") should be("ickquay astfay unray")
  }
}
