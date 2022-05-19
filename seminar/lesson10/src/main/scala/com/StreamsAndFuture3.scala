package com

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source}

import java.time.LocalTime
import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor, Future}
import scala.util.Random

// Задание 3:
// 3.1 - Сравнить запуск запросов к DB - Future.traverse и запуск на Stream-ах
// 3.2 - Ограничить кол-во запросов к DB - чтобы одновременно выполнялось только 10 параллельных запросов, чтобы она не упала
// 3.2.2 - с сохранением порядка элементов

object StreamsAndFuture3 extends App {
  implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(25))
  implicit val system: ActorSystem = ActorSystem("system", defaultExecutionContext = Option(ec))

  val range: Seq[Int] = Range(1, 100)

  def fDbcall(i: Int): Future[String] = Future {
    Thread.sleep(Random.between(1000, 4000))
    //Thread.sleep(4000)
    println(s"executed #${i}")
    s"result of f for number #${i}"
  }

  // 3.1 - Сравнить запуск запросов к DB - Future.traverse и запуск на Stream-ах



  // 3.2 - Ограничить кол-во запросов к DB - чтобы одновременно выполнялось только 10 параллельных запросов, чтобы она не упала
  // 3.2.2 - с сохранением порядка элементов

}
