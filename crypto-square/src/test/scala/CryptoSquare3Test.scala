import org.scalatest.{FunSuite, Matchers}

/** @version 3.2.0 */
class CryptoSquare3Test extends FunSuite with Matchers {

  test("empty plaintext results in an empty ciphertext") {
    CryptoSquare3.ciphertext("") should be("")
  }

  test("Lowercase") {
    CryptoSquare3.ciphertext("A") should be("a")
  }

  test("Remove spaces") {
    CryptoSquare3.ciphertext("  b ") should be("b")
  }

  test("Remove punctuation") {
    CryptoSquare3.ciphertext("@1,%!") should be("1")
  }

  test("9 character plaintext results in 3 chunks of 3 characters") {
    CryptoSquare3.ciphertext("This is fun!") should be("tsf hiu isn")
  }

  test(
    "8 character plaintext results in 3 chunks, the last one with a trailing space") {
    CryptoSquare3.ciphertext("Chill out.") should be("clu hlt io ")
  }

  test(
    "54 character plaintext results in 7 chunks, the last two with trailing spaces") {
    CryptoSquare3.ciphertext(
      "If man was meant to stay on the ground, god would have given us roots.") should be(
      "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau ")
  }
}
