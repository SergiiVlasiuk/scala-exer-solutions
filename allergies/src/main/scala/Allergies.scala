object Allergies {
  def list(code: Int): List[Allergen] = Allergen.allergens.filter(allergicTo(_, code))

  def allergicTo(alergen: Allergen, code: Int): Boolean = (code & alergen.getAllergyNum) != 0
}

abstract sealed class Allergen(allergyNum: Int) {
  def getAllergyNum = allergyNum
}

object Allergen {
  case object Eggs extends Allergen(1)
  case object Peanuts extends Allergen(2)
  case object Shellfish extends Allergen(4)
  case object Strawberries extends Allergen(8)
  case object Tomatoes extends Allergen(16)
  case object Chocolate extends Allergen(32)
  case object Pollen extends Allergen(64)
  case object Cats extends Allergen(128)

  val allergens: List[Allergen] = List(Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats)
}