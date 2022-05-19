package com

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.{ClosedShape, IOResult, UniformFanOutShape}
import akka.stream.scaladsl.{Broadcast, FileIO, Flow, GraphDSL, RunnableGraph, Sink, Source}
import akka.util.ByteString
import com.LogGenerator.genLogs

import scala.concurrent.Future

// Работа с Graph-ами - https://doc.akka.io/docs/akka/current/stream/stream-graphs.html

object LogSplitter5 extends App {

    // Task 3 - Пишем наш обычный stream для вывода в файл через Graph DSL
    // Знакомимся с RunnableGraph
    // - Он Runnable, так как его можно запустить, так как он полностью сконструирован (закрыты все входы/выходы)
    // - if there are no unwired ports, the graph is closed, and therefore can be materialized
    // - поэтому и возвращаем в конце ClosedShape.

    // Условие - используем "~>" для конструирования
    // Заготовка:
    val logProcessor = RunnableGraph.fromGraph(GraphDSL.create() { implicit b =>
      import GraphDSL.Implicits._

      // in ~> ... ~> out

      ClosedShape
    })



    // Task 4 - Пишем LogSplitter с помощью Graph DSL :
    // Требования к поведению LogSplitter-а
    // - каждый уровнень логов пишем в свой файл
    // - все пришедшие логи, независимо от уровня выводим в консоль

    // Task 4.1 - составляем схему из элементов akka-streams, которая подходит под требования:
    // комната 1 - https://miro.com/app/board/uXjVO0nom6w=/
    // комната 2 - https://miro.com/app/board/uXjVO0n_uMc=/
    // там же - выбрать подходящий https://doc.akka.io/docs/akka/current/stream/stream-graphs.html#constructing-graphs

    // Task 4.2 - пишем реализацию

    // Заготовка:
    val logSplitter = RunnableGraph.fromGraph(GraphDSL.create() { implicit b =>
      import GraphDSL.Implicits._

      // in ~> ... ~> out

      ClosedShape
    })
}
