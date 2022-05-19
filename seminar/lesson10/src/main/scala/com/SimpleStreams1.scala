package com

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.IOResult
import akka.stream.scaladsl.{FileIO, Flow, Sink, Source}
import akka.util.ByteString

import java.nio.file.{Path, Paths}
import scala.concurrent.Future
import scala.util.Random

// Композиция-создание стримов:
// https://maxcom.github.io/scala-course-2022/slides/day10.html#/12
// https://doc.akka.io/docs/akka/current/stream/stream-composition.html

object SimpleStreams1 extends App {

  // Задание 1.1: Написать Stream, который печатает логи (независимо от их уровня), в консоль (STDOUT). Источник логов - LogGenerator.genLogs()
  // Подсказка-слайд: https://maxcom.github.io/scala-course-2022/slides/day10.html#/19
  // Заготовка задания:
  // - в академических целях - разделяем source, sink, flow
  // - также, хорошо будет на первых этапах добавлять результирующий тип, чтобы лучше понимать происходящее
  // Подсказка: запуск stream-а -  всем методы, которые запускают стрим содержать “run” в имени метода
  def sourceTask1 = ???
  def sinkTask1 = ???



  // Задание 1.2: Написать Stream, который печатает логи (только уровня ERROR), в файл.
  // Подсказка-слайд: https://maxcom.github.io/scala-course-2022/slides/day10.html#/19
  // Полезная документация: https://doc.akka.io/api/akka/2.6/akka/stream/scaladsl/FileIO$.html
  // Функция создания файла - FileUtils.createFile(filename)
  // Заготовка задания: (в академических целях - разделяем source, sink, flow, - чтобы умели работать с ними как с "кирпичиками"):
  def sourceTask2 = ???
  def flowTask2 = ???
  def sinkTask2 = ???
}

object LogGenerator {
  def genLogs(size: Int, recordLength: Int): Seq[String] = {
    val levels = Map(0 -> "INFO", 1 -> "WARN", 2 -> "ERROR")
    (1 to size).map { _ =>
      s"${levels(Random.nextInt(3))}:${Random.alphanumeric.take(recordLength).mkString("")}"
    }
  }
}

object FileUtils {
  def createFile(filename: String): Path = Paths.get(filename)
}
