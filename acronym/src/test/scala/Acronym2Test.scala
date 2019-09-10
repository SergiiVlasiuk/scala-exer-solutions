import org.scalatest.{FunSuite, Matchers}

/** @version 1.6.0 */
class Acronym2Test extends FunSuite with Matchers {

  test("basic") {
    Acronym2.abbreviate("Portable Network Graphics") should be("PNG")
  }

  test("lowercase words") {
    Acronym2.abbreviate("Ruby on Rails") should be("ROR")
  }

  test("punctuation") {
    Acronym2.abbreviate("First In, First Out") should be("FIFO")
  }

  test("all caps word") {
    Acronym2.abbreviate("GNU Image Manipulation Program") should be("GIMP")
  }

  test("punctuation without whitespace") {
    Acronym2.abbreviate("Complementary metal-oxide semiconductor") should be("CMOS")
  }

  test("very long abbreviation") {
    Acronym2.abbreviate("Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me") should be("ROTFLSHTMDCOALM")
  }

  test("consecutive delimiters") {
    Acronym2.abbreviate("Something - I made up from thin air") should be("SIMUFTA")
  }

  test("apostrophes") {
    Acronym2.abbreviate("Halley's Comet") should be("HC")
  }
}
