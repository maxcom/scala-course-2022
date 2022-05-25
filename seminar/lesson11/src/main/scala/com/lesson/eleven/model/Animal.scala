package com.lesson.eleven.model

import org.http4s.{ParseFailure, QueryParamDecoder}

sealed trait Animal { def name: String }

object Animal {
  case object Dog extends Animal { val name = "dog" }
  case object Cat extends Animal { val name = "cat" }

  def unapply(input: String): Option[Animal] = input match {
    case Dog.name => Some(Dog)
    case Cat.name => Some(Cat)
    case _ => None
  }

  implicit val animalParamDecoder: QueryParamDecoder[Animal] = ???
}


