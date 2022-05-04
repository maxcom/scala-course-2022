package ru.allebedev.core

import java.time.Instant

import scala.concurrent.Future

class FakeDbService() {

  def getInitialData: Future[Seq[String]] = {
    Thread.sleep(5000)
    Future.successful(Seq("first", "second", "third"))
  }

  def getData: Future[Seq[String]] =
    Future.successful(Seq("first", "second", "third"))

  def getFatal: Future[Seq[String]] = Future.failed(new DbFatalExeption)

  def throwThrowable: Future[Seq[String]] = throw new Throwable("Ops! (0_o)/`````")

  def stamp(list: Seq[DataForStamp]): Future[Seq[DataForStamp]] =
    Future.successful(list.map(_.copy(stamp = Some(Instant.now()))))

}

object FakeDbService {

  def apply: FakeDbService = new FakeDbService()

}