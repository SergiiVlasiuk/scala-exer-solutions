import java.util.concurrent.Executors

import scala.concurrent._
import scala.concurrent.duration._

object Frequency2 {
  def frequency(numWorkers: Int, texts: Seq[String]): Map[Char, Int] = texts match {
    case Seq() => Map()
    case _ =>
      implicit val executionContext = createContext(numWorkers)
      val mapsOfFrequencies: Seq[Future[Map[Char, Int]]] = texts.map(text => Future(countChars(text)))
      val totalFrequencies = Future.foldLeft(mapsOfFrequencies.toList)(Map.empty[Char, Int])(reduce)
      Await.result(totalFrequencies, 1 seconds)
  }

  private def countChars(text: String): Map[Char, Int] = {
    text.toLowerCase.filter(_.isLetter).groupBy(identity).map(x => (x._1, x._2.length))
  }

  private def reduce(map1: Map[Char, Int], map2: Map[Char, Int]): Map[Char, Int] =
    map1 ++ map2.map { case (k, v) => k -> (v + map1.getOrElse(k, 0)) }

  private def createContext(numWorker: Int): ExecutionContextExecutorService = {
    val executorService = Executors.newFixedThreadPool(numWorker)
    ExecutionContext.fromExecutorService(executorService)
  }
}

object FrequencyOld {
  //  def frequency(numWorkers: Int, texts: Seq[String]): Map[Char, Int] = texts match {
  //    case Seq() => Map()
  //    case _ =>
  //      val string = texts.par.reduce(_ ++ _)
  //      val copy = string.toLowerCase.par.filter(_.isLetter)
  //      copy.groupBy(identity).map(x => (x._1, x._2.size)).seq
  //  }
  def frequency(numWorkers: Int, texts: Seq[String]): Map[Char, Int] = texts match {
    case Seq() => Map()
    case _ =>
      val string = texts.reduce(_ ++ _)
      val copy = string.toLowerCase.filter(_.isLetter)
      copy.groupBy(identity).map(x => (x._1, x._2.size)).seq
  }
}
