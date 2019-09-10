object FlattenArray {

  def flatten(list: List[Any]): List[Any] = list flatMap {
    case i: List[_] => flatten(i)
    case e => List(e)
  } filter (_.!=(null))

}
