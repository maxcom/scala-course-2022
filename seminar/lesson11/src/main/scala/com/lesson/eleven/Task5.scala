package com.lesson.eleven

import cats.effect._
import com.lesson.eleven.model.RegistrationData
import com.lesson.eleven.service.FakeDBService
import org.http4s._
import org.http4s.circe.CirceEntityCodec._
import org.http4s.dsl.io._


object Task5 {

  // Префикс для всех роутов должен быть /task5
  val routes: HttpRoutes[IO] = businessLogicUnsafe


  // POST /business-logic
  // Entity: Json[RegistrationData]
  // 200 OK, "Department: $department"
  // 400 BadRequest с ошибкой
  def businessLogicUnsafe: HttpRoutes[IO] = ???

}

