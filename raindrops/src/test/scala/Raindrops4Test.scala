import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class Raindrops4Test extends FunSuite with Matchers {

  test("the sound for 1 is 1") {
    Raindrops4.convert(1) should be("1")
  }

  test("the sound for 3 is Pling") {
    Raindrops4.convert(3) should be("Pling")
  }

  test("the sound for 5 is Plang") {
    Raindrops4.convert(5) should be("Plang")
  }

  test("the sound for 7 is Plong") {
    Raindrops4.convert(7) should be("Plong")
  }

  test("the sound for 6 is Pling as it has a factor 3") {
    Raindrops4.convert(6) should be("Pling")
  }

  test("2 to the power 3 does not make a raindrop sound as 3 is the exponent not the base") {
    Raindrops4.convert(8) should be("8")
  }

  test("the sound for 9 is Pling as it has a factor 3") {
    Raindrops4.convert(9) should be("Pling")
  }

  test("the sound for 10 is Plang as it has a factor 5") {
    Raindrops4.convert(10) should be("Plang")
  }

  test("the sound for 14 is Plong as it has a factor of 7") {
    Raindrops4.convert(14) should be("Plong")
  }

  test("the sound for 15 is PlingPlang as it has factors 3 and 5") {
    Raindrops4.convert(15) should be("PlingPlang")
  }

  test("the sound for 21 is PlingPlong as it has factors 3 and 7") {
    Raindrops4.convert(21) should be("PlingPlong")
  }

  test("the sound for 25 is Plang as it has a factor 5") {
    Raindrops4.convert(25) should be("Plang")
  }

  test("the sound for 27 is Pling as it has a factor 3") {
    Raindrops4.convert(27) should be("Pling")
  }

  test("the sound for 35 is PlangPlong as it has factors 5 and 7") {
    Raindrops4.convert(35) should be("PlangPlong")
  }

  test("the sound for 49 is Plong as it has a factor 7") {
    Raindrops4.convert(49) should be("Plong")
  }

  test("the sound for 52 is 52") {
    Raindrops4.convert(52) should be("52")
  }

  test("the sound for 105 is PlingPlangPlong as it has factors 3, 5 and 7") {
    Raindrops4.convert(105) should be("PlingPlangPlong")
  }

  test("the sound for 3125 is Plang as it has a factor 5") {
    Raindrops4.convert(3125) should be("Plang")
  }
}
