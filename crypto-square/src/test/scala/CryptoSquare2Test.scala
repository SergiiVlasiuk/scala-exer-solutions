import org.scalatest.{FunSuite, Matchers}

/** @version 3.2.0 */
class CryptoSquare2Test extends FunSuite with Matchers {

  test("empty plaintext results in an empty ciphertext") {
    CryptoSquare2.ciphertext("") should be("")
  }

  test("Lowercase") {
    CryptoSquare2.ciphertext("A") should be("a")
  }

  test("Remove spaces") {
    CryptoSquare2.ciphertext("  b ") should be("b")
  }

  test("Remove punctuation") {
    CryptoSquare2.ciphertext("@1,%!") should be("1")
  }

  test("9 character plaintext results in 3 chunks of 3 characters") {
    CryptoSquare2.ciphertext("This is fun!") should be("tsf hiu isn")
  }

  test(
    "8 character plaintext results in 3 chunks, the last one with a trailing space") {
    CryptoSquare2.ciphertext("Chill out.") should be("clu hlt io ")
  }

  test(
    "54 character plaintext results in 7 chunks, the last two with trailing spaces") {
    CryptoSquare2.ciphertext(
      "If man was meant to stay on the ground, god would have given us roots.") should be(
      "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau ")
  }
}
