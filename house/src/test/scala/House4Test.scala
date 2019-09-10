import org.scalatest.{FunSuite, Matchers}

class House4Test extends FunSuite with Matchers {

  test("verse one - the house that jack built") {
    House4.recite(1, 1) should be(
      """This is the house that Jack built.

""")
  }

  test("verse two - the malt that lay") {
    House4.recite(2, 2) should be(
      """This is the malt that lay in the house that Jack built.

""")
  }

  test("verse three - the rat that ate") {
    House4.recite(3, 3) should be(
      """This is the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse four - the cat that killed") {
    House4.recite(4, 4) should be(
      """This is the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse five - the dog that worried") {
    House4.recite(5, 5) should be(
      """This is the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse six - the cow with the crumpled horn") {
    House4.recite(6, 6) should be(
      """This is the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse seven - the maiden all forlorn") {
    House4.recite(7, 7) should be(
      """This is the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse eight - the man all tattered and torn") {
    House4.recite(8, 8) should be(
      """This is the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse nine - the priest all shaven and shorn") {
    House4.recite(9, 9) should be(
      """This is the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse 10 - the rooster that crowed in the morn") {
    House4.recite(10, 10) should be(
      """This is the rooster that crowed in the morn that woke the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse 11 - the farmer sowing his corn") {
    House4.recite(11, 11) should be(
      """This is the farmer sowing his corn that kept the rooster that crowed in the morn that woke the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("verse 12 - the horse and the hound and the horn") {
    House4.recite(12, 12) should be(
      """This is the horse and the hound and the horn that belonged to the farmer sowing his corn that kept the rooster that crowed in the morn that woke the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("multiple verses") {
    House4.recite(4, 8) should be(
      """This is the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }

  test("full rhyme") {
    House4.recite(1, 12) should be(
      """This is the house that Jack built.
This is the malt that lay in the house that Jack built.
This is the rat that ate the malt that lay in the house that Jack built.
This is the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the rooster that crowed in the morn that woke the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the farmer sowing his corn that kept the rooster that crowed in the morn that woke the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.
This is the horse and the hound and the horn that belonged to the farmer sowing his corn that kept the rooster that crowed in the morn that woke the priest all shaven and shorn that married the man all tattered and torn that kissed the maiden all forlorn that milked the cow with the crumpled horn that tossed the dog that worried the cat that killed the rat that ate the malt that lay in the house that Jack built.

""")
  }
}
