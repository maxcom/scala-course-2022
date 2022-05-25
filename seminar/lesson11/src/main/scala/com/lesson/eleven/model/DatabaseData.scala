package com.lesson.eleven.model

import org.mindrot.jbcrypt.BCrypt

import java.util.UUID

case class DatabaseData(id: UUID = UUID.randomUUID(),
                        login: String,
                        passwordHash: String,
                        department: String)

object DatabaseData {

  def apply(login: String, password: String, department: String): DatabaseData =
    DatabaseData(
      id = UUID.randomUUID(),
      login = login,
      passwordHash = BCrypt.hashpw(password, BCrypt.gensalt()),
      department = department
    )

}
