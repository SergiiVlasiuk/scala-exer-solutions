object Dominoes3 {
  def chain(in: Seq[(Int, Int)]): Option[List[(Int, Int)]] = {
    if (in.isEmpty) Some(Nil)
    else if (in.size == 1) if (in.head.swap == in.head) Some(in.toList) else None
    else {
      def loop(ds: Seq[(Int, Int)], acc: Seq[(Int, Int)] = Seq()): List[(Int, Int)] =
        (acc.lastOption, ds.headOption) match {
          case (Some((_, a)), Some((b, _))) if (a == b) => loop(ds.drop(1), acc :+ ds.head)
          case (Some((_, a)), Some((_, b))) if (a == b) => loop(ds.drop(1), acc :+ ds.head.swap)
          case (_, None) => (acc.headOption, acc.lastOption) match {
            case (Some((a, _)), Some((_, b))) if (a == b) => acc.toList
            case _ => Nil
          }
          case (None, _) => loop(ds.drop(1), acc ++ ds.take(1))
          case _ => Nil
        }

      in.permutations.map(p => loop(p)).find(_.nonEmpty)
    }
  }
}
