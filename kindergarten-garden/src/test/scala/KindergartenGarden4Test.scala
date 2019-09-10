import org.scalatest.{FunSuite, Matchers}

class KindergartenGarden4Test extends FunSuite with Matchers {

  test("partial garden - garden with single student") {
    Garden4.defaultGarden4("RC\nGG").plants("Alice") should be(
      List(Plant4.Radishes, Plant4.Clover, Plant4.Grass, Plant4.Grass))
  }

  test("partial garden - different garden with single student") {
    Garden4.defaultGarden4("VC\nRC").plants("Alice") should be(
      List(Plant4.Violets, Plant4.Clover, Plant4.Radishes, Plant4.Clover))
  }

  test("partial garden - garden with two students") {
    Garden4.defaultGarden4("VVCG\nVVRC").plants("Bob") should be(
      List(Plant4.Clover, Plant4.Grass, Plant4.Radishes, Plant4.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - second student's garden") {
    Garden4.defaultGarden4("VVCCGG\nVVCCGG").plants("Bob") should be(
      List(Plant4.Clover, Plant4.Clover, Plant4.Clover, Plant4.Clover))
  }

  test(
    "multiple students for the same garden with three students, partial garden - third student's garden") {
    Garden4.defaultGarden4("VVCCGG\nVVCCGG").plants("Charlie") should be(
      List(Plant4.Grass, Plant4.Grass, Plant4.Grass, Plant4.Grass))
  }

  test("full garden - first student's garden") {
    Garden4
      .defaultGarden4("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Alice") should be(
      List(Plant4.Violets, Plant4.Radishes, Plant4.Violets, Plant4.Radishes))
  }

  test("full garden - second student's garden") {
    Garden4
      .defaultGarden4("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Bob") should be(
      List(Plant4.Clover, Plant4.Grass, Plant4.Clover, Plant4.Clover))
  }

  test("full garden - second to last student's garden") {
    Garden4
      .defaultGarden4("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Kincaid") should be(
      List(Plant4.Grass, Plant4.Clover, Plant4.Clover, Plant4.Grass))
  }

  test("full garden - last student's garden") {
    Garden4
      .defaultGarden4("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV")
      .plants("Larry") should be(
      List(Plant4.Grass, Plant4.Violets, Plant4.Clover, Plant4.Violets))
  }
}
