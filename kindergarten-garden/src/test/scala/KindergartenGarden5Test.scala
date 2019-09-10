import org.scalatest.{FunSuite, Matchers}

class KindergartenGarden5Test extends FunSuite with Matchers {

  test("partial garden - garden with single student") {
    Garden5.defaultGarden5("RC\nGG").plants("Alice") should be(
      List(Plant5.Radishes, Plant5.Clover, Plant5.Grass, Plant5.Grass))
  }

  test("partial garden - different garden with single student") {
    Garden5.defaultGarden5("VC\nRC").plants("Alice") should be(
      List(Plant5.Violets, Plant5.Clover, Plant5.Radishes, Plant5.Clover))
  }

  test("partial garden - garden with two students") {
    Garden5.defaultGarden5("VVCG\nVVRC").plants("Bob") should be(
      List(Plant5.Clover, Plant5.Grass, Plant5.Radishes, Plant5.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - second student's garden") {
    Garden5.defaultGarden5("VVCCGG\nVVCCGG").plants("Bob") should be(
      List(Plant5.Clover, Plant5.Clover, Plant5.Clover, Plant5.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - third student's garden") {
    Garden5.defaultGarden5("VVCCGG\nVVCCGG").plants("Charlie") should be(
      List(Plant5.Grass, Plant5.Grass, Plant5.Grass, Plant5.Grass))
  }

  test("full garden - first student's garden") {
    Garden5.defaultGarden5("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Alice") should be(List(Plant5.Violets, Plant5.Radishes, Plant5.Violets, Plant5.Radishes))
  }

  test("full garden - second student's garden") {
    Garden5.defaultGarden5("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Bob") should be(List(Plant5.Clover, Plant5.Grass, Plant5.Clover, Plant5.Clover))
  }

  test("full garden - second to last student's garden") {
    Garden5.defaultGarden5("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Kincaid") should be(List(Plant5.Grass, Plant5.Clover, Plant5.Clover, Plant5.Grass))
  }

  test("full garden - last student's garden") {
    Garden5.defaultGarden5("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Larry") should be(List(Plant5.Grass, Plant5.Violets, Plant5.Clover, Plant5.Violets))
  }
}
