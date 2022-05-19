package com

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source}

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success, Try}

// Задание 4: Написать stream, который будет суммировать по 10 элементов и в результате возвращать Seq сумм

object StreamGroup4 extends App {

  implicit val system: ActorSystem = ActorSystem("system")
  implicit val ex: ExecutionContextExecutor = system.getDispatcher

  val range: Seq[Int] = Range(1, 20)
}
