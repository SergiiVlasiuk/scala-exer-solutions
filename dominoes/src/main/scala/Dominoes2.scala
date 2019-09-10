object Dominoes2 {
  type Dominoes2 = List[(Int, Int)]

  def chain(ds: Dominoes2): Option[Dominoes2] = {
    def validEnds(ds: Dominoes2) = ds.head._1 == ds.last._2

    @annotation.tailrec
    def chainFor(ds: Dominoes2, chainOption: Option[Dominoes2] = Some(List())): Option[Dominoes2] =
      ds match {
        case Nil => Some(Nil)
        case last :: Nil => chainOption.map(last :: _)
        case f :: s :: tail if f._2 == s._1 => chainFor(s :: tail, chainOption.map(f :: _))
        case f :: s :: tail if f._2 == s._2 => chainFor(s.swap :: tail, chainOption.map(f :: _))
        case _ :: _ :: _ => None
      }

    ds match {
      case Nil => Some(Nil)
      case (l, r) :: Nil if l == r => Some(ds)
      case _ :: _ => ds.permutations.filter(validEnds)
        .map(chainFor(_).map(_.reverse))
        .find(_.isDefined)
        .flatten
      case _ => None
    }
  }
}