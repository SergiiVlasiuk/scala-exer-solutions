import scala.collection.immutable.TreeMap

class School {
  type DB = Map[Int, Seq[String]]
  private var dataStore: DB = Map()

  def add(name: String, g: Int) = {
    dataStore += (g -> (grade(g) :+ name))
  }

  def db: DB = dataStore

  def grade(g: Int): Seq[String] = dataStore.getOrElse(g, Seq())

  def sorted: DB = TreeMap(dataStore.toSeq: _*).mapValues(seq => seq.sorted)








































  //  type DB = Map[Int, List[String]]
  //  var storage: DB = Map[Int, List[String]]()
  //
  //  def add(name: String, g: Int) = storage +=(g -> (grade(g):::name::Nil))
  //
  //  def db: DB = storage
  //
  //  def grade(g: Int): List[String] = storage.get(g) match {
  //    case None => List()
  //    case Some(x) => x
  //  }
  //
  //  def sorted: DB = ListMap(storage.toSeq.sortBy(_._1):_*)
}
