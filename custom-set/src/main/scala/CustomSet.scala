case class CustomSet[T](values: Set[T])

object CustomSet {
  def isEqual[T](set1: CustomSet[T], set2: CustomSet[T]) = set1.values equals set2.values

  def isDisjointFrom[T](set1: CustomSet[T], set2: CustomSet[T]) = empty(intersection(set1, set2))

  def isSubsetOf[T](set1: CustomSet[T], set2: CustomSet[T]) = set1.values subsetOf set2.values

  def member[T](set: CustomSet[T], value: T) = set.values contains value

  def empty[T](set: CustomSet[T]) = set.values.isEmpty

  def insert[T](set: CustomSet[T], value: T) = CustomSet[T](set.values + value)

  def union[T](set1: CustomSet[T], set2: CustomSet[T]) = CustomSet[T](set1.values union set2.values)

  def difference[T](set1: CustomSet[T], set2: CustomSet[T]) = CustomSet[T](set1.values diff set2.values)

  def intersection[T](set1: CustomSet[T], set2: CustomSet[T]) = CustomSet[T](set1.values intersect set2.values)

  def fromList[T](list: List[T]) = CustomSet[T](list.toSet)
}
