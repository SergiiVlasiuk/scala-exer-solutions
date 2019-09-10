import org.scalacheck.Arbitrary
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

/** @version created manually **/
class SimpleLinkedList2Test extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks {

  private implicit def arbitrarySimpleLinkedList2[T](implicit arbitraryTs: Arbitrary[Array[T]]): Arbitrary[SimpleLinkedList2[T]] =
    Arbitrary {
      arbitraryTs.arbitrary map (SimpleLinkedList2(_: _*))
    }

  it should "handle single item list" in {
    val list = SimpleLinkedList2().add(1)
    list.isEmpty should be(false)
    list.value should be(1)
  }

  it should "handle single item has no next item" in {
    val list = SimpleLinkedList2().add(1)
    list.next.isEmpty should be(true)
  }

  it should "handle two item list" in {
    val list = SimpleLinkedList2().add(1).add(2)
    list.value should be(1)
    list.next.value should be(2)
  }

  it should "handle two item list has no next value" in {
    val list = SimpleLinkedList2().add(1).add(2)
    list.next.next.isEmpty should be(true)
  }

  it should "allow creation from a Seq" in {
    val list = SimpleLinkedList2.fromSeq(List(3, 2, 1))
    list.value should be(3)
    list.next.value should be(2)
    list.next.next.value should be(1)
  }

  it should "allow conversion to a Seq" in {
    val list = SimpleLinkedList2.fromSeq(List(3, 2, 1))
    val seq = list.toSeq
    seq should be(List(3, 2, 1))
  }

  it should "handle reverse" in {
    val list = SimpleLinkedList2.fromSeq(List(1, 2, 3, 4, 5, 6))
    val reversed = list.reverse
    reversed.value should be(6)
    reversed.next.value should be(5)
    reversed.next.next.value should be(4)
    reversed.next.next.next.value should be(3)
    reversed.next.next.next.next.value should be(2)
    reversed.next.next.next.next.next.value should be(1)
  }

  it should "handle arbitrary list fromSeq toSeq" in {
    forAll { seq: Seq[Int] =>
      assert(SimpleLinkedList2.fromSeq(seq).toSeq == seq)
    }
  }

  it should "handle reverse arbitrary list " in {
    forAll { seq: Seq[Int] =>
      assert(SimpleLinkedList2.fromSeq(seq).reverse.toSeq == seq.reverse)
    }
  }

  it should "reverse arbitrary list back to original" in {
    forAll { list: SimpleLinkedList2[Int] =>
      assert(list.reverse.reverse.toSeq == list.toSeq)
    }
  }

  it should "return correct arbitrary value at index" in {
    def nthDatum(list: SimpleLinkedList2[Int], i: Int): Int = {
      (0 until i).foldLeft(list)((acc, j) => acc.next).value
    }

    forAll { xs: Seq[Int] =>
      whenever(xs.nonEmpty) {
        val list = SimpleLinkedList2.fromSeq(xs)
        xs.indices.foreach {
          i => assert(nthDatum(list, i) == xs(i))
        }
      }
    }
  }

  it should "return original arbitrary list from added list elements" in {
    forAll { xs: Seq[Int] =>
      val list = xs.foldLeft(SimpleLinkedList2[Int]())(_.add(_))
      assert(list.toSeq == xs)
    }
  }

  it should "handle arbitrary generics" in {
    forAll { xs: Seq[String] =>
      assert(SimpleLinkedList2.fromSeq(xs).toSeq == xs)
    }
  }
}