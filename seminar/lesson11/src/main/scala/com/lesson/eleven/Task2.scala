package com.lesson.eleven

import cats.data.{NonEmptyList, Validated}
import cats.effect._
import cats.syntax.all._
import com.lesson.eleven.model.Animal
import org.http4s._
import org.http4s.dsl.io.{QueryParamDecoderMatcher, _}

object Task2 {

  // Префикс для всех роутов должен быть /task2
  val routes: HttpRoutes[IO] = ???


  // 2.1
  // GET /boolean ? inverted : Boolean
  // 200 OK, "Boolean: $boolean"
  def boolean: HttpRoutes[IO] = ???


  // 2.2
  // GET /flag ? flag
  // 200 OK, "Flag: $flag"
  def flag: HttpRoutes[IO] = ???


  // 2.3
  // GET /love ? animal : Animal
  // 200 OK, "I love $animal"
  def love: HttpRoutes[IO] = ???


  // 2.5
  // GET /default-love ? animal : Option[Animal] = Dog
  // 200 OK, "I love $animal"
  def defaultLove: HttpRoutes[IO] = ???


  // 2.5
  // GET /multi-love ? animals : Animal & animals : Animal ...
  // 200 OK, "I love all animals: ${animal.mkString(", ")}"
  def multiLove: HttpRoutes[IO] = ???


}
