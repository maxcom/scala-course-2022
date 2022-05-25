package com.lesson.eleven


import cats.effect._
import cats.syntax.all._
import org.http4s._
import org.http4s.dsl.io._

import scala.concurrent.duration._


object Task6 {

  // Префикс для всех роутов должен быть /task6
  val routes: HttpRoutes[IO] = ???

  private val timeout: FiniteDuration = 10.second

  // 6.1
  private def counting(n: Int): IO[Unit] = ???


  // 6.1
  // PUT /count/:num
  // По окончании: 201 Created
  def count: HttpRoutes[IO] = ???


  // 6.2
  // PUT /count-with-timeout/:num
  // По окончании: 201 Created или 408 RequestTimeout
  def countWithTimeout: HttpRoutes[IO] = ???


  // 6.3
  // PUT /start-counter/:num
  // Сразу: 201 Created
  // Защиту в виде таймаута нужно сохранить.
  def countAsync: HttpRoutes[IO] = ???

}

