object CustomSet4Play {
  type CustomSet4Play[T] = (T => Boolean, Unit => Seq[T])

  def fromList[T](xs: Seq[T]): CustomSet4Play[T] = (xs contains _, _ => xs)
  def toList[T](s: CustomSet4Play[T]) : Seq[T] = s._2(())
  def empty[T](s: CustomSet4Play[T]): Boolean = s._2(()).isEmpty
  def size[T](s: CustomSet4Play[T]): Int = s._2(()).size
  def member[T](s: CustomSet4Play[T], x: T): Boolean = s._1(x)
  def singleton[T](s: CustomSet4Play[T]): Boolean = s._2(()).size == 1

  def insert[T](s: CustomSet4Play[T], x: T): CustomSet4Play[T] =
    if (s._1(x)) s else (y => x == y || s._1(y), u => x +: s._2(u))

  def delete[T](s: CustomSet4Play[T], x: T): CustomSet4Play[T] =
    if (!s._1(x)) s else (y => x != y && s._1(y), u => s._2(u).filter(_ != x))

  def isSubsetOf[T](a: CustomSet4Play[T], b: CustomSet4Play[T]): Boolean =
    a._2(()) forall (b._1(_))

  def isDisjointFrom[T](a: CustomSet4Play[T], b: CustomSet4Play[T]): Boolean =
    (a._2(()) forall (!b._1(_))) && (b._2(()) forall (!a._1(_)))

  def union[T](a: CustomSet4Play[T], b: CustomSet4Play[T]): CustomSet4Play[T] =
    (x => a._1(x) || b._1(x), u => a._2(u) union b._2(u).filterNot(a._1(_)))

  def difference[T](a: CustomSet4Play[T], b: CustomSet4Play[T]): CustomSet4Play[T] =
    (x => a._1(x) ^ b._1(x), u => a._2(u).filterNot(b._1(_)) union b._2(u).filterNot(a._1(_)))

  def intersection[T](a: CustomSet4Play[T], b: CustomSet4Play[T]): CustomSet4Play[T] =
    (x => a._1(x) && b._1(x), u => a._2(u).filter(b._1(_)))
}