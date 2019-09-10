import java.time.LocalDate

import monocle.macros.GenLens

import scala.language.postfixOps

object LensPerson {

  case class Person(_name: Name, _born: Born, _address: Address)

  case class Name(_foreNames: String /*Space separated*/ , _surName: String)

  // Value of java.time.LocalDate.toEpochDay
  type EpochDay = Long

  case class Born(_bornAt: Address, _bornOn: EpochDay)

  case class Address(_street: String, _houseNumber: Int,
                     _place: String /*Village / city*/ , _country: String)

  // Valid values of Gregorian are those for which 'java.time.LocalDate.of'
  // returns a valid LocalDate.
  case class Gregorian(_year: Int, _month: Int, _dayOfMonth: Int)

  // Implement these.

  /*
    // START of my solution is
    lazy val bornStreet: Born => String = _._bornAt._street
    lazy val setCurrentStreet: String => Person => Person =
      street => person => person
        .copy(_address = person._address
          .copy(_street = street))
    lazy val setBirthMonth: Int => Person => Person =
      month => person => person
        .copy(_born = person._born
          .copy(_bornOn = LocalDate.ofEpochDay(person._born._bornOn).withMonth(month).toEpochDay))
    // Transform both birth and current street names.
    lazy val renameStreets: (String => String) => Person => Person =
      fun => person => person
        .copy(_born = person._born
          .copy(_bornAt = person._born._bornAt
            .copy(_street = fun(person._born._bornAt._street))),
          _address = person._address
            .copy(fun(person._address._street)))
    // END of my solution is
  */
  //solution borrowed from Wows. I like it because it shows how to use project dependency (monocle-core, monocle-macro)
  private val addressLens = GenLens[Person](_._address)
  private val bornLens = GenLens[Person](_._born)
  private val bornAddressLens = GenLens[Born](_._bornAt)
  private val streetLens = GenLens[Address](_._street)
  private val birthDateLens = GenLens[Person](_._born._bornOn)

  val bornStreet: Born => String = bornAddressLens composeLens streetLens get
  val setCurrentStreet: String => Person => Person =
    s => p => (addressLens composeLens streetLens).modify(_ => s)(p)
  val setBirthMonth: Int => Person => Person = month => p =>
    birthDateLens.modify(day => {
      val date = LocalDate.ofEpochDay(day)
      LocalDate.of(date.getYear, month, date.getDayOfMonth).toEpochDay
    })(p)
  // Transform both birth and current street names.
  val renameStreets: (String => String) => Person => Person = f =>
    p => {
      val person = (bornLens composeLens bornAddressLens composeLens streetLens).modify(s => f(s))(p)
      (addressLens composeLens streetLens).modify(s => f(s))(person)
    }
}
