package seminar

import seminar.Practice._

import java.io.Closeable
import java.util.UUID
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.io.{BufferedSource, Source}
import scala.util.{Random, Try}

object Main extends App {



}

object Practice {
  type Result = Int
  type Id     = UUID

  private val defaultFileName = "in.txt"
  private val defaultDelay = 5.seconds

  private def getSource: BufferedSource =
    Source.fromResource(defaultFileName)

  private def read(in: BufferedSource): Future[Iterator[String]] =
    Future(blocking(in.getLines()))

  def asyncWithResource[R <: Closeable, A](resource: R)(f: R => Future[A]): Future[A] =
    f(resource).andThen { case _ => resource.close() }

  def awaitAndPrint[A](resultF: Future[A]): Unit =
    Await.result(resultF, defaultDelay) match {
      case seq: Seq[_] => seq.foreach(println)
      case simple => println(simple)
    }


  // Кол-во строк в файле
  def countFileLinesF: Future[Int] = {
    ???
  }


  // Для каждой строки: строка и её длина
  def linesWithLengthF: Future[Seq[(String, Int)]] = {
    ???
  }


  // Сумма длин всех строк
  def totalLengthF: Future[Int] = {
    ???
  }


  // Разделить все строки на группы
  def splitToBucketsF: Future[Seq[Bucket]] = {
    ???
  }


  // Собрать статистику по файлу
  def calculateStatsF: Future[Stats] = {
    ???
  }


  // Вернуть самую быструю Future из двух
  def shortestFuture[A](first: Future[A], second: Future[A]): Future[A] = {
    ???
  }


  // Вернуть самую долгую Future из двух
  def longestFuture[A](first: Future[A], second: Future[A]): Future[A] = {
    ???
  }

  val largeList: List[Id] = (1 to 100).map(_ => UUID.randomUUID()).toList

  def query(id: Id): Future[Result] = Future {
    println("Running very long func")
    Thread.sleep(5000)
    new Random().nextInt()
  }


  // Применить функцию query ко всем элементам коллекции
  def seqSolve(ids: List[Id])(f: Id => Future[Result]): Future[List[Result]] = {
    ???
  }


  // Заменить реализацию seqSolve на разбивку по батчам
  def batch(ids: Seq[Id], batchSize: Int)(f: Id => Future[Result]): Future[Seq[Result]] = {
    ???
  }


  // Кол-во строк короче maxLength
  def countShorterThanF(maxLength: Int): Future[Int] = {
    ???
  }


  // Напечатать строку с задержкой
  def printWithDelayF(s: String, delay: FiniteDuration): Future[Unit] = {
    ???
  }


  // Sleep sort
  // https://www.quora.com/What-is-sleep-sort
  def sleepSortF: Future[Unit] = {
    ???
  }

}

case class Bucket(linesCount: Int,
                  minLineLength: Int,
                  maxLineLength: Int)

object Bucket {
  val DefaultBucketSize = 10
}

case class Stats(linesCount: Int,
                 minLineLength: Int,
                 averageLineLength: Int,
                 maxLineLength: Int,
                 buckets: Seq[Bucket]) {

  override def toString =
    s"""Total line count: $linesCount
       |  min: $minLineLength
       |  avg: $averageLineLength
       |  max: $maxLineLength
       |
       |  buckets:
       |${
      buckets.map { bucket =>
        s"  - ${bucket.minLineLength}-${bucket.maxLineLength}: ${bucket.linesCount}"
      }.mkString("\n")
    }""".stripMargin
}
