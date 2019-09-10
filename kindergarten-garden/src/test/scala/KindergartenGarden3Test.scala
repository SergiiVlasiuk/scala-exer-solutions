import org.scalatest.{FunSuite, Matchers}

class KindergartenGarden3Test extends FunSuite with Matchers {

  test("partial garden - garden with single student") {
    Garden3.defaultGarden3("RC\nGG").plants("Alice") should be(
      List(Plant3.Radishes, Plant3.Clover, Plant3.Grass, Plant3.Grass))
  }

  test("partial garden - different garden with single student") {
    Garden3.defaultGarden3("VC\nRC").plants("Alice") should be(
      List(Plant3.Violets, Plant3.Clover, Plant3.Radishes, Plant3.Clover))
  }

  test("partial garden - garden with two students") {
    Garden3.defaultGarden3("VVCG\nVVRC").plants("Bob") should be(
      List(Plant3.Clover, Plant3.Grass, Plant3.Radishes, Plant3.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - second student's garden") {
    Garden3.defaultGarden3("VVCCGG\nVVCCGG").plants("Bob") should be(
      List(Plant3.Clover, Plant3.Clover, Plant3.Clover, Plant3.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - third student's garden") {
    Garden3.defaultGarden3("VVCCGG\nVVCCGG").plants("Charlie") should be(
      List(Plant3.Grass, Plant3.Grass, Plant3.Grass, Plant3.Grass))
  }

  test("full garden - first student's garden") {
    Garden3
      .defaultGarden3("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Alice") should be(
      List(Plant3.Violets, Plant3.Radishes, Plant3.Violets, Plant3.Radishes))
  }

  test("full garden - second student's garden") {
    Garden3
      .defaultGarden3("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Bob") should be(
      List(Plant3.Clover, Plant3.Grass, Plant3.Clover, Plant3.Clover))
  }

  test("full garden - second to last student's garden") {
    Garden3
      .defaultGarden3("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Kincaid") should be(
      List(Plant3.Grass, Plant3.Clover, Plant3.Clover, Plant3.Grass))
  }

  test("full garden - last student's garden") {
    Garden3
      .defaultGarden3("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Larry") should be(
      List(Plant3.Grass, Plant3.Violets, Plant3.Clover, Plant3.Violets))
  }
}
