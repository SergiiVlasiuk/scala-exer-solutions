class Robot2 {
  var name: String = NameManager2.getName

  def reset() = {
    val oldName = name
    name = NameManager2.getName
    NameManager2.releaseName(oldName)
  }
}

object NameManager2 {
  private var availableNames: Seq[String] = {
    val alpha = 'A' to 'Z'
    val numeric = 0 to 9
    for (a <- alpha;
         b <- alpha;
         c <- numeric;
         d <- numeric;
         e <- numeric)
      yield (s"$a$b$c$d$e")
  }

  def getName: String = {
    availableNames.headOption match {
      case None => throw new Exception("All names are in use")
      case Some(name) => {
        availableNames = availableNames.tail
        name
      }
    }
  }

  def releaseName(name: String) = {
    availableNames = name +: availableNames
  }
}