package com

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Sink, Source}

import java.time.LocalTime
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration.DurationInt

/*
  Задание 2: Написать Stream, который печатает в консоль цифры, с органичением - 2 результата каждые 5 секунд
 */
object StreamThrottle2 extends App {
  val range: Seq[Int] = Range(1, 20)

}
