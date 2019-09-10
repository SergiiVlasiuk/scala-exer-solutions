class CustomSet2[+T](input: List[T]) {
  val values = input.distinct
}

object CustomSet2 {
  def isEqual[T](set1: CustomSet2[T], set2: CustomSet2[T]) = set1.values.length == set2.values.length && set1.values.forall(member(set2, _))

  def isDisjointFrom[T](set1: CustomSet2[T], set2: CustomSet2[T]) = !set1.values.exists(member(set2, _))

  def isSubsetOf[T](set1: CustomSet2[T], set2: CustomSet2[T]) = set1.values.forall(member(set2, _))

  def member[T](set: CustomSet2[T], value: T) = set.values.contains(value)

  def empty[T](set: CustomSet2[T]) = set.values.isEmpty

  def insert[T](set: CustomSet2[T], value: T) = new CustomSet2[T](value :: set.values)

  def union[T](set1: CustomSet2[T], set2: CustomSet2[T]) = new CustomSet2[T](set1.values ++ set2.values)

  def difference[T](set1: CustomSet2[T], set2: CustomSet2[T]) = fromList(set1.values.filter(!member(set2, _)))

  def intersection[T](set1: CustomSet2[T], set2: CustomSet2[T]) = fromList(set1.values.filter(member(set2, _)))

  def fromList[T](list: List[T]) = new CustomSet2[T](list)
}
