import org.scalatest.{FunSuite, Matchers}

class KindergartenGarden2Test extends FunSuite with Matchers {

  test("partial garden - garden with single student") {
    Garden2.defaultGarden2("RC\nGG").plants("Alice") should be(
      List(Plant2.Radishes, Plant2.Clover, Plant2.Grass, Plant2.Grass))
  }

  test("partial garden - different garden with single student") {
    Garden2.defaultGarden2("VC\nRC").plants("Alice") should be(
      List(Plant2.Violets, Plant2.Clover, Plant2.Radishes, Plant2.Clover))
  }

  test("partial garden - garden with two students") {
    Garden2.defaultGarden2("VVCG\nVVRC").plants("Bob") should be(
      List(Plant2.Clover, Plant2.Grass, Plant2.Radishes, Plant2.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - second student's garden") {
    Garden2.defaultGarden2("VVCCGG\nVVCCGG").plants("Bob") should be(
      List(Plant2.Clover, Plant2.Clover, Plant2.Clover, Plant2.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - third student's garden") {
    Garden2.defaultGarden2("VVCCGG\nVVCCGG").plants("Charlie") should be(
      List(Plant2.Grass, Plant2.Grass, Plant2.Grass, Plant2.Grass))
  }

  test("full garden - first student's garden") {
    Garden2
      .defaultGarden2("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Alice") should be(
      List(Plant2.Violets, Plant2.Radishes, Plant2.Violets, Plant2.Radishes))
  }

  test("full garden - second student's garden") {
    Garden2
      .defaultGarden2("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Bob") should be(
      List(Plant2.Clover, Plant2.Grass, Plant2.Clover, Plant2.Clover))
  }

  test("full garden - second to last student's garden") {
    Garden2
      .defaultGarden2("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Kincaid") should be(
      List(Plant2.Grass, Plant2.Clover, Plant2.Clover, Plant2.Grass))
  }

  test("full garden - last student's garden") {
    Garden2
      .defaultGarden2("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Larry") should be(
      List(Plant2.Grass, Plant2.Violets, Plant2.Clover, Plant2.Violets))
  }
}
