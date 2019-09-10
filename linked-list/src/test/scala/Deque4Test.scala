import org.scalatest.{FlatSpec, Matchers}

/** @version created manually **/
class Deque4Test extends FlatSpec with Matchers {

  it should "handle push then pop" in {
    val deque = Deque4[Char]()
    deque.push('a')
    deque.push('b')
    deque.pop should be (Some('b'))
    deque.pop should be (Some('a'))
    deque.pop should be (None)
  }

  it should "handle push then shift" in {
val deque = Deque4[Char]()
    deque.push('a')
    deque.push('b')
    deque.shift should be (Some('a'))
    deque.shift should be (Some('b'))
    deque.shift should be (None)
  }

  it should "handle unshift then shift" in {
val deque = Deque4[Char]()
    deque.unshift('a')
    deque.unshift('b')
    deque.shift should be (Some('b'))
    deque.shift should be (Some('a'))
  }

  it should "handle unshift then pop" in {
val deque = Deque4[Char]()
    deque.unshift('a')
    deque.unshift('b')
    deque.pop should be (Some('a'))
    deque.pop should be (Some('b'))
  }

  it should "handle complex interaction" in {
val deque = Deque4[Int]()
    deque.push(1)
    deque.push(2)
    deque.pop should be (Some(2))
    deque.push(3)
    deque.unshift(4)
    deque.push(5)
    deque.shift should be (Some(4))
    deque.pop should be (Some(5))
    deque.pop should be (Some(3))
  }
}
