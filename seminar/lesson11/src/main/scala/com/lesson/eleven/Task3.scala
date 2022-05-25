package com.lesson.eleven

import cats.effect._
import com.lesson.eleven.model.RegistrationData
import org.http4s._
import org.http4s.circe.CirceEntityCodec._
import org.http4s.dsl.io._

object Task3 {

  // Префикс для всех роутов должен быть /task3
  val routes: HttpRoutes[IO] = userData


  // GET /user-data
  // 200 OK, Json[RegistrationData]
  def userData: HttpRoutes[IO] = ???


}

