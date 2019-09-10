object CustomSet3 {
  def fromList(data : List[Any]) = data.toSet

  def empty(set : Set[Any]) : Boolean = set.isEmpty

  def member(set : Set[Any], item : Any) : Boolean = set contains item

  def isSubsetOf(set1 : Set[Any], set2 : Set[Any]) : Boolean = set1 subsetOf set2

  def isDisjointFrom(set1: Set[Any], set2: Set[Any]) : Boolean = empty(intersection(set1, set2))

  def isEqual(set1: Set[Any], set2: Set[Any]) : Boolean = set1 equals set2

  def insert(set : Set[Any], data : Any) : Set[Any] = set + data

  def intersection(set1: Set[Any], set2: Set[Any]) : Set[Any] = set1 intersect set2

  def difference(set1: Set[Any], set2: Set[Any]) : Set[Any] = set1 diff set2

  def union(set1: Set[Any], set2: Set[Any]) : Set[Any] = set1 union set2
}