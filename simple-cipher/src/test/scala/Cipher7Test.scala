import org.scalatest.{FunSuite, Matchers}

/** @version created manually **/
class Cipher7Test extends FunSuite with Matchers {

  test("Random key cipher - can encode/decode") {
    // Here we take advantage of the fact that plaintext of "aaa..."
    // outputs the key. This is a critical problem with shift ciphers, some
    // characters will always output the key verbatim.

    val cipher = Cipher7(None)
    cipher.encode("aaaaaaaaaa") should be(cipher.key.substring(0, 10))
    cipher.decode(cipher.key.substring(0, 10)) should be("aaaaaaaaaa")
  }

  test("Invalid key - contains caps") {
    intercept[IllegalArgumentException] {
      Cipher7(Some("ABCD"))
    }
  }

  test("Invalid key - contains numerics") {
    intercept[IllegalArgumentException] {
      Cipher7(Some("123"))
    }
  }

  test("Invalid key - is empty") {
    intercept[IllegalArgumentException] {
      Cipher7(Some(""))
    }
  }

  test("Substitution cipher - can encode") {
    Cipher7(Some("abcdefghij")).encode("aaaaaaaaaa") should be("abcdefghij")
  }

  test("Substitution cipher - can decode") {
    Cipher7(Some("abcdefghij")).decode("abcdefghij") should be("aaaaaaaaaa")
  }

  test("Substitution cipher - is reversible") {
    val cipher = Cipher7(Some("abcdefghij"))
    cipher.decode(cipher.encode("abcdefghij")) should be("abcdefghij")
  }

  test("Substitution cipher - can double shift") {
    val cipher = Cipher7(Some("iamapandabear"))
    cipher.encode("iamapandabear") should be("qayaeaagaciai")
  }

  test("Substitution cipher - can wrap") {
    Cipher7(Some("abcdefghij")).encode("zzzzzzzzzz") should be("zabcdefghi")
  }
}
