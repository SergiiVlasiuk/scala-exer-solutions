case class CustomSet4[+T](values: List[T])

object CustomSet4 {
  def isEqual[T](set1: CustomSet4[T], set2: CustomSet4[T]) = set1.values.length == set2.values.length && set1.values.forall(member(set2, _))

  def isDisjointFrom[T](set1: CustomSet4[T], set2: CustomSet4[T]) = !set1.values.exists(member(set2, _))

  def isSubsetOf[T](set1: CustomSet4[T], set2: CustomSet4[T]) = set1.values.forall(member(set2, _))

  def member[T](set: CustomSet4[T], value: T) = set.values.contains(value)

  def empty[T](set: CustomSet4[T]) = set.values.isEmpty

  def insert[T](set: CustomSet4[T], value: T) = CustomSet4[T](value :: set.values)

  def union[T](set1: CustomSet4[T], set2: CustomSet4[T]) = CustomSet4[T](set1.values ++ set2.values)

  def difference[T](set1: CustomSet4[T], set2: CustomSet4[T]) = fromList(set1.values.filter(!member(set2, _)))

  def intersection[T](set1: CustomSet4[T], set2: CustomSet4[T]) = fromList(set1.values.filter(member(set2, _)))

  def fromList[T](list: List[T]) = CustomSet4[T](list)

  def apply[T](input: List[T]): CustomSet4[T] = new CustomSet4[T](input.distinct)
}
