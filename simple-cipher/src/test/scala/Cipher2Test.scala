import org.scalatest.{FunSuite, Matchers}

/** @version created manually **/
class Cipher2Test extends FunSuite with Matchers {

  test("Random key cipher - can encode/decode") {
    // Here we take advantage of the fact that plaintext of "aaa..."
    // outputs the key. This is a critical problem with shift ciphers, some
    // characters will always output the key verbatim.

    val cipher = Cipher2(None)
    cipher.encode("aaaaaaaaaa") should be(cipher.key.substring(0, 10))
    cipher.decode(cipher.key.substring(0, 10)) should be("aaaaaaaaaa")
  }

  test("Invalid key - contains caps") {
    intercept[IllegalArgumentException] {
      Cipher2(Some("ABCD"))
    }
  }

  test("Invalid key - contains numerics") {
    intercept[IllegalArgumentException] {
      Cipher2(Some("123"))
    }
  }

  test("Invalid key - is empty") {
    intercept[IllegalArgumentException] {
      Cipher2(Some(""))
    }
  }

  test("Substitution cipher - can encode") {
    Cipher2(Some("abcdefghij")).encode("aaaaaaaaaa") should be("abcdefghij")
  }

  test("Substitution cipher - can decode") {
    Cipher2(Some("abcdefghij")).decode("abcdefghij") should be("aaaaaaaaaa")
  }

  test("Substitution cipher - is reversible") {
    val cipher = Cipher2(Some("abcdefghij"))
    cipher.decode(cipher.encode("abcdefghij")) should be("abcdefghij")
  }

  test("Substitution cipher - can double shift") {
    val cipher = Cipher2(Some("iamapandabear"))
    cipher.encode("iamapandabear") should be("qayaeaagaciai")
  }

  test("Substitution cipher - can wrap") {
    Cipher2(Some("abcdefghij")).encode("zzzzzzzzzz") should be("zabcdefghi")
  }
}
