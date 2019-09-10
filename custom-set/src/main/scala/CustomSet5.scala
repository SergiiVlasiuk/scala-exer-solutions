case class CustomSet5[+T](values: List[T])

object CustomSet5 {
  //  def isEqual[T](set1: CustomSet5[T], set2: CustomSet5[T]) = set1.values.length == set2.values.length && set1.values.forall(member(set2, _))
  def isEqual[T](set1: CustomSet5[T], set2: CustomSet5[T]) = set1.values.toSet equals set2.values.toSet

  def isDisjointFrom[T](set1: CustomSet5[T], set2: CustomSet5[T]) = empty(intersection(set1, set2))

  //  def isSubsetOf[T](set1: CustomSet5[T], set2: CustomSet5[T]) = set1.values.forall(member(set2, _))
  def isSubsetOf[T](set1: CustomSet5[T], set2: CustomSet5[T]) = set1.values.toSet subsetOf set2.values.toSet

  def member[T](set: CustomSet5[T], value: T) = set.values.contains(value)

  def empty[T](set: CustomSet5[T]) = set.values.isEmpty

  def insert[T](set: CustomSet5[T], value: T) = CustomSet5[T](value :: set.values)

  def union[T](set1: CustomSet5[T], set2: CustomSet5[T]) = CustomSet5[T](set1.values union set2.values)

  def difference[T](set1: CustomSet5[T], set2: CustomSet5[T]) = CustomSet5[T](set1.values diff set2.values)

  def intersection[T](set1: CustomSet5[T], set2: CustomSet5[T]) = CustomSet5[T](set1.values intersect set2.values)

  def fromList[T](list: List[T]) = CustomSet5[T](list)

  def apply[T](input: List[T]): CustomSet5[T] = new CustomSet5[T](input.distinct)
}
