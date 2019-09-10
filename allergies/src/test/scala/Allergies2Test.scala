import org.scalatest.{FunSuite, Matchers}

/** @version 1.2.0 */
class Allergies2Test extends FunSuite with Matchers {

  test("Allergen2.Peanuts - no allergies means not allergic") {
    Allergies2.allergicTo(Allergen2.Peanuts, 0) should be(false)
  }

  test("Allergen2.Cats - no allergies means not allergic") {
    Allergies2.allergicTo(Allergen2.Cats, 0) should be(false)
  }

  test("Allergen2.Strawberries - no allergies means not allergic") {
    Allergies2.allergicTo(Allergen2.Strawberries, 0) should be(false)
  }

  test("Allergen2.Eggs - is allergic to eggs") {
    Allergies2.allergicTo(Allergen2.Eggs, 1) should be(true)
  }

  test("Allergen2.Eggs - allergic to eggs in addition to other stuff") {
    Allergies2.allergicTo(Allergen2.Eggs, 5) should be(true)
  }

  test("Allergen2.Shellfish - allergic to eggs in addition to other stuff") {
    Allergies2.allergicTo(Allergen2.Shellfish, 5) should be(true)
  }

  test("Allergen2.Strawberries - allergic to eggs in addition to other stuff") {
    Allergies2.allergicTo(Allergen2.Strawberries, 5) should be(false)
  }

  test("Allergen2.Eggs - allergic to strawberries but not peanuts") {
    Allergies2.allergicTo(Allergen2.Eggs, 9) should be(true)
  }

  test("Allergen2.Peanuts - allergic to strawberries but not peanuts") {
    Allergies2.allergicTo(Allergen2.Peanuts, 9) should be(false)
  }

  test("Allergen2.Shellfish - allergic to strawberries but not peanuts") {
    Allergies2.allergicTo(Allergen2.Shellfish, 9) should be(false)
  }

  test("Allergen2.Strawberries - allergic to strawberries but not peanuts") {
    Allergies2.allergicTo(Allergen2.Strawberries, 9) should be(true)
  }

  test("no allergies at all") {
    Allergies2.list(0) should be(List())
  }

  test("allergic to just eggs") {
    Allergies2.list(1) should be(List(Allergen2.Eggs))
  }

  test("allergic to just peanuts") {
    Allergies2.list(2) should be(List(Allergen2.Peanuts))
  }

  test("allergic to just strawberries") {
    Allergies2.list(8) should be(List(Allergen2.Strawberries))
  }

  test("allergic to eggs and peanuts") {
    Allergies2.list(3) should be(List(Allergen2.Eggs, Allergen2.Peanuts))
  }

  test("allergic to more than eggs but not peanuts") {
    Allergies2.list(5) should be(List(Allergen2.Eggs, Allergen2.Shellfish))
  }

  test("allergic to lots of stuff") {
    Allergies2.list(248) should be(
      List(Allergen2.Strawberries,
        Allergen2.Tomatoes,
        Allergen2.Chocolate,
        Allergen2.Pollen,
        Allergen2.Cats))
  }

  test("allergic to everything") {
    Allergies2.list(255) should be(
      List(Allergen2.Eggs,
        Allergen2.Peanuts,
        Allergen2.Shellfish,
        Allergen2.Strawberries,
        Allergen2.Tomatoes,
        Allergen2.Chocolate,
        Allergen2.Pollen,
        Allergen2.Cats))
  }

  test("ignore non allergen score parts") {
    Allergies2.list(509) should be(
      List(Allergen2.Eggs,
        Allergen2.Shellfish,
        Allergen2.Strawberries,
        Allergen2.Tomatoes,
        Allergen2.Chocolate,
        Allergen2.Pollen,
        Allergen2.Cats))
  }
}
