package com.lesson.eleven

import cats.effect._
import com.lesson.eleven.model.RegistrationData
import org.http4s._
import org.http4s.circe.CirceEntityCodec._
import org.http4s.dsl.io._


object Task4 {

  // Префикс для всех роутов должен быть /task4
  val routes: HttpRoutes[IO] = signup


  // POST /signup
  // Entity: Json[RegistrationData]
  // 200 OK, "Boolean: $boolean"
  // 400 BadRequest, если некорректное тело
  def signup: HttpRoutes[IO] = ???

}

