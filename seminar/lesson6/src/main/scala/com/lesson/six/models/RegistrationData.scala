package com.lesson.six.models

case class RegistrationData(login: String,
                            password: String,
                            firstName: Option[String],
                            lastName: Option[String],
                            age: Option[Int])
