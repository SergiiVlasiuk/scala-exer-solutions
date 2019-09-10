import org.scalatest.{FunSuite, Matchers}

/** @version 1.3.0 */
class NucleotideCount4Test extends FunSuite with Matchers {

  test("empty strand") {
    new DNA4("").nucleotideCounts should be(
      Right(Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)))
  }

  test("can count one nucleotide in single-character input") {
    new DNA4("G").nucleotideCounts should be(
      Right(Map('A' -> 0, 'C' -> 0, 'G' -> 1, 'T' -> 0)))
  }

  test("strand with repeated nucleotide") {
    new DNA4("GGGGGGG").nucleotideCounts should be(
      Right(Map('A' -> 0, 'C' -> 0, 'G' -> 7, 'T' -> 0)))
  }

  test("strand with multiple nucleotides") {
    new DNA4(
      "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC").nucleotideCounts should be(
      Right(Map('A' -> 20, 'C' -> 12, 'G' -> 17, 'T' -> 21)))
  }

  test("strand with invalid nucleotides") {
    new DNA4("AGXXACT").nucleotideCounts.isLeft should be(true)
  }
}
