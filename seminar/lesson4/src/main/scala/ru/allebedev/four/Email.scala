package ru.allebedev.four

import play.api.libs.json.{JsObject, JsSuccess, JsValue, Json, JsonValidationError, OFormat, Reads, Writes}

// Написать reads и writes для Email - реализовать методы toJson и toEmail
sealed trait Endpoint

case class EmailAddress(value: String) extends Endpoint

case class Group(id: String, name: Option[String]) extends Endpoint

case class Person(personId: String, fullname: Option[String]) extends Endpoint

// Реализовать у Email метод toJson
case class Email(source: Endpoint, destination: Endpoint)

object Email {

  def toJson(email: Email): JsValue = ???

  def toEmail(jsonStr: String): Email = ???

}

object Person {
  implicit val emailAddressFormat: OFormat[Person] = Json.format[Person]
}

object Group {
  implicit val emailAddressFormat: OFormat[Group] = Json.format[Group]
}

object EmailAddress {
  implicit val emailAddressFormat: OFormat[EmailAddress] = Json.format[EmailAddress]
}
