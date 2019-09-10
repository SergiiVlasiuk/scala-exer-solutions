object HighScores {
  def personalTop(scores: List[Int]): List[Int] = scores.sortBy(-_) take 3

  def personalBest(scores: List[Int]): Int = scores.max

  def latest(scores: List[Int]): Int = scores.last

  def report(scores: List[Int]): String = {
    val latestScore: Int = latest(scores)
    val best = personalBest(scores)
    val diff = if(best <= latestScore) ""
    else  best - latestScore + " short of "
    s"Your latest score was ${latestScore}. That's ${diff}your personal best!"
  }
}
