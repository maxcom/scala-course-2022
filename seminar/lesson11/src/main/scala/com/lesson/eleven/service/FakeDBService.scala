package com.lesson.eleven.service

import cats.effect.{IO, Resource, ResourceIO}
import com.lesson.eleven.model.{DatabaseData, RegistrationData}
import org.mindrot.jbcrypt.BCrypt

import java.util.UUID

object FakeDBService {

  type Database = Set[DatabaseData]

  private val generateDatabase: IO[Database] = IO {
    Set(
      DatabaseData("user", "Qwe12345", "Developers"),
      DatabaseData("superuser", "SuperSecure", "IT Crowd")
    )
  }

  private val database: ResourceIO[Database] = Resource.eval(generateDatabase)


  def findUser(login: String): IO[Option[UUID]] = ???

  def checkPassword(userId: UUID, candidate: String): IO[Boolean] = ???

  def getDepartmentUnsafe(userId: UUID): IO[String] = ???

}
