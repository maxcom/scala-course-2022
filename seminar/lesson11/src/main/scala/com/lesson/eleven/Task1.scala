package com.lesson.eleven

import cats.effect._
import cats.syntax.all._
import com.lesson.eleven.model.Animal
import org.http4s._
import org.http4s.dsl.io._

object Task1 {

  // Префикс для всех роутов должен быть /task1
  val routes: HttpRoutes[IO] = ???


  // 1.1
  // GET /hello
  // 200 OK, "Hello"
  def hello: HttpRoutes[IO] = ???


  // 1.2
  // GET /hello/:name
  // 200 OK, "Hello, $name"
  def helloName: HttpRoutes[IO] = ???


  // 1.3
  // GET /love/:animal
  // где animal имеет тип sealed trait Animal
  // см. org.http4s.dsl.impl.PathVar
  // 200 OK, "I love ${animal.name}s"
  def loveAnimals: HttpRoutes[IO] = ???


}
