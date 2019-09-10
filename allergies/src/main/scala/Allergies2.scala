object Allergies2 {
  def allergicTo(allergen: Allergen2.Value, allergyScore: Int): Boolean =
    (allergen.id & allergyScore) > 0

  def list(allergyScore: Int): List[Allergen2.Value] =
//    Allergen2.values.toList.filter { allergicTo(_, allergyScore) }
    Allergen2.values.filter { allergicTo(_, allergyScore) }.toList
}

object Allergen2 extends Enumeration {
  val Eggs = Value(1)
  val Peanuts = Value(2)
  val Shellfish = Value(4)
  val Strawberries = Value(8)
  val Tomatoes = Value(16)
  val Chocolate = Value(32)
  val Pollen = Value(64)
  val Cats = Value(128)
}
