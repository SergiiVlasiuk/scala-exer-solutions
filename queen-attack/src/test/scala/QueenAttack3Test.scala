import org.scalatest.{FunSuite, Matchers}

/** @version 2.1.0 */
class QueenAttack3Test extends FunSuite with Matchers {

  private def create(x: Int, y: Int): Queen3 = {
    Queen3.create(x, y) match {
      case Some(q) => q
      case None => fail("Error creating queen")
    }
  }

  test("queen with a valid position") {
    Queen3.create(2, 2) should be(Some(Queen3(2, 2)))
  }

  test("queen must have positive row") {
    Queen3.create(-2, 2) should be(None)
  }

  test("queen must have row on board") {
    Queen3.create(8, 4) should be(None)
  }

  test("queen must have positive column") {
    Queen3.create(2, -2) should be(None)
  }

  test("queen must have column on board") {
    Queen3.create(4, 8) should be(None)
  }

  test("can not attack") {
    Queen3Attack.canAttack(create(2, 4), create(6, 6)) should be(false)
  }

  test("can attack on same row") {
    Queen3Attack.canAttack(create(2, 4), create(2, 6)) should be(true)
  }

  test("can attack on same column") {
    Queen3Attack.canAttack(create(4, 5), create(2, 5)) should be(true)
  }

  test("can attack on first diagonal") {
    Queen3Attack.canAttack(create(2, 2), create(0, 4)) should be(true)
  }

  test("can attack on second diagonal") {
    Queen3Attack.canAttack(create(2, 2), create(3, 1)) should be(true)
  }

  test("can attack on second diagonal2") {
    val queen1 = create(2, 2)
    val queen2 = create(3, 1)
    val queen3 = create(4, 1)
//    val queen4 = create(-4, 1)
    println(s"queen1: $queen1, queen2: $queen2, queen3: $queen3")
    Queen3Attack.canAttack(queen1, queen2) should be(true)
    Queen3Attack.canAttack(queen1, queen3) should be(false)
//    Queen3Attack.canAttack(queen1, queen4) should be(false)
  }

  test("can attack on third diagonal") {
    Queen3Attack.canAttack(create(2, 2), create(1, 1)) should be(true)
  }

  test("can attack on fourth diagonal") {
    Queen3Attack.canAttack(create(2, 2), create(5, 5)) should be(true)
  }
}
