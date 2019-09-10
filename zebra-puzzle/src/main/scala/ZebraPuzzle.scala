object ZebraPuzzle {

  sealed trait Resident extends Product with Serializable

  case object Englishman extends Resident

  case object Spaniard extends Resident

  case object Ukrainian extends Resident

  case object Norwegian extends Resident

  case object Japanese extends Resident

  val residents = List(Spaniard, Ukrainian, Englishman, Japanese, Norwegian)

  sealed trait Cigarettes extends Product with Serializable

  case object OldGold extends Cigarettes

  case object Kools extends Cigarettes

  case object Chesterfield extends Cigarettes

  case object LuckyStrike extends Cigarettes

  case object Parliaments extends Cigarettes

  val cigs = List(OldGold, Kools, Chesterfield, LuckyStrike, Parliaments)


  sealed trait Drinks extends Product with Serializable

  case object Coffee extends Drinks

  case object Tea extends Drinks

  case object Milk extends Drinks

  case object OrangeJuice extends Drinks

  case object Water extends Drinks

  val drinks = List(Coffee, Tea, Milk, OrangeJuice, Water)
  val indexOfMiddle: Int = drinks.size / 2

  sealed trait Pets extends Product with Serializable

  case object Dog extends Pets

  case object Fox extends Pets

  case object Horse extends Pets

  case object Snails extends Pets

  case object Zebra extends Pets

  val pets = List(Dog, Fox, Horse, Snails, Zebra)


  sealed trait Colors extends Product with Serializable

  case object Red extends Colors

  case object Green extends Colors

  case object Ivory extends Colors

  case object Yellow extends Colors

  case object Blue extends Colors

  val colors = List(Red, Green, Ivory, Yellow, Blue)


  case class Solution(waterDrinker: Resident, zebraOwner: Resident)

  def aNextToB[A, B](a: A, aList: List[A], b: B, bList: List[B]): Boolean = Math.abs(differenceOfIndex(a, aList, b, bList)) == 1

  def aHasB[A, B](a: A, aList: List[A], b: B, bList: List[B]): Boolean = aList(bList.indexOf(b)) == a

  def aToRightOfB[A, B](a: A, aList: List[A], b: B, bList: List[B]): Boolean = differenceOfIndex(a, aList, b, bList) == 1

  private def differenceOfIndex[B, A](a: A, aList: List[A], b: B, bList: List[B]) = {
    aList.indexOf(a) - bList.indexOf(b)
  }

  private def initialColorCheck(colorList: List[Colors], residentList: List[Resident]): Boolean = {
    aHasB(Englishman, residentList, Red, colorList) &&
      aNextToB(Norwegian, residentList, Blue, colorList) &&
      aToRightOfB(Green, colorList, Ivory, colorList)
  }

  private def initialDrinkCheck(residentList: _root_.scala.collection.immutable.List[ZebraPuzzle.Resident], colorList: _root_.scala.collection.immutable.List[ZebraPuzzle.Colors], drinkList: _root_.scala.collection.immutable.List[ZebraPuzzle.Drinks]) = {
    drinkList(indexOfMiddle) == Milk &&
      aHasB(Coffee, drinkList, Green, colorList) &&
      aHasB(Tea, drinkList, Ukrainian, residentList)

  }

  private def whoDoesWhat[A](a: A, aList: List[A], residentList: List[Resident]): Resident = residentList(aList.indexOf(a))

  lazy val solve: Solution = (for {
    residentList <- residents.permutations if residentList(0) == Norwegian
    colorList <- colors.permutations if initialColorCheck(colorList, residentList)
    petList <- pets.permutations if aHasB(Spaniard, residentList, Dog, petList)
    drinkList <- drinks.permutations if initialDrinkCheck(residentList, colorList, drinkList)
    cigaretteList <- cigs.permutations
    if aHasB(OldGold, cigaretteList, Snails, petList) &&
      aNextToB(Chesterfield, cigaretteList, Fox, petList) &&
      aHasB(Kools, cigaretteList, Yellow, colorList) &&
      aNextToB(Kools, cigaretteList, Horse, petList) &&
      aHasB(LuckyStrike, cigaretteList, OrangeJuice, drinkList) &&
      aHasB(Japanese, residentList, Parliaments, cigaretteList)
    whoDrinksWater = whoDoesWhat(Water, drinkList, residentList)
    whoOwnsZebra = whoDoesWhat(Zebra, petList, residentList)
  } yield Solution(whoDrinksWater, whoOwnsZebra)).toList(0)
}
