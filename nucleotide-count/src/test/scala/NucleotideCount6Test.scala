import org.scalatest.{FunSuite, Matchers}

/** @version 1.3.0 */
class NucleotideCount6Test extends FunSuite with Matchers {

  test("empty strand") {
    new DNA6("").nucleotideCounts should be(
      Right(Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)))
  }

  test("can count one nucleotide in single-character input") {
    new DNA6("G").nucleotideCounts should be(
      Right(Map('A' -> 0, 'C' -> 0, 'G' -> 1, 'T' -> 0)))
  }

  test("strand with repeated nucleotide") {
    new DNA6("GGGGGGG").nucleotideCounts should be(
      Right(Map('A' -> 0, 'C' -> 0, 'G' -> 7, 'T' -> 0)))
  }

  test("strand with multiple nucleotides") {
    new DNA6(
      "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC").nucleotideCounts should be(
      Right(Map('A' -> 20, 'C' -> 12, 'G' -> 17, 'T' -> 21)))
  }

  test("strand with invalid nucleotides") {
//    new DNA6("AGXXACT").nucleotideCounts.isLeft should be(true)
  }
}
