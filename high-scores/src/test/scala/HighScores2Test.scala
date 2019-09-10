import org.scalatest.{FunSuite, Matchers}

/** @version 2.0.0 */
class HighScores2Test extends FunSuite with Matchers {

  test("Latest score") {
    HighScores2.latest(List(100, 0, 90, 30)) should be(30)
  }

  test("Personal best") {
    HighScores2.personalBest(List(40, 100, 70)) should be(100)
  }

  test("Personal top") {
    HighScores2.personalTop(List(50, 30, 10)) should be(List(50, 30, 10))
  }

  test("Personal top highest to lowest") {
    HighScores2.personalTop(List(20, 10, 30)) should be(List(30, 20, 10))
  }

  test("Personal top when there is a tie") {
    HighScores2.personalTop(List(40, 20, 40, 30)) should be(List(40, 40, 30))
  }

  test("Personal top when there are less than 3") {
    HighScores2.personalTop(List(30, 70)) should be(List(70, 30))
  }

  test("Personal top when there is only one") {
    HighScores2.personalTop(List(40)) should be(List(40))
  }

  test("Personal top from a long list") {
    HighScores2.personalTop(
      List(10, 30, 90, 30, 100, 20, 10, 0, 30, 40, 40, 70, 70)) should be(
      List(100, 90, 70))
  }

  test("Message for new personal best") {
    HighScores2.report(List(20, 40, 0, 30, 70)) should be(
      "Your latest score was 70. That's your personal best!")
  }

  test("Message when latest score is not the highest score") {
    HighScores2.report(List(20, 100, 0, 30, 70)) should be(
      "Your latest score was 70. That's 30 short of your personal best!")
  }

  test("Message for repeated personal best") {
    HighScores2.report(List(20, 70, 50, 70, 30)) should be(
      "Your latest score was 30. That's 40 short of your personal best!")
  }
}
