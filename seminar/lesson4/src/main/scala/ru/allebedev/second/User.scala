package ru.allebedev.second

import play.api.libs.json.{Format, JsError, JsSuccess, JsValue, Json, JsonValidationError, OFormat, Reads, Writes, __}
// TODO: comment it - to pay attention
import play.api.libs.functional.syntax._

// Задание:
// Реализовать метод toUser, который принимает json как строку и который должен возвращать User-а, если удается его создать
// Написать разные reads для User и посмотреть разницу работы
// Не делаем reads implicit - передаем явно разные reads и смотрим разницу
// 1 - Написать Reads для User - через монаду (через for)
// 2 - Написать Reads для User - через tupled + apply
// 3 - Написать валидаторы, которые валидировали бы поля по правилам:
// Правила валидации к User
// - Login - содержит только латинские буквы и цифры (\w)
// - Password - не менее 6 символов, не из супер-известных паролей(Qwe12345 и 123456) и состоит из букв и цифр (\w)
// - Address - номер дома положительный
// - email - имеет формат email-адреса: address@mail.ru - ^\S+@\S+\.\S+$  или ^\w+@\w+\.\w+$

// Дополнительно
// 3 - Как при чтении удалить пробелы в login // Пишем через map и через combined
// 4 - Что делать, если у класса одно лишнее поле
// 4 - Преобразовать один reads в другой - с помощью map
// 5 - Попробовать написать write или format - с unapply

case class Address(street: String, houseNumber: Int)
case class User(login: String, password: String, address: Address, email: String)

object User {
  val validationLoginError = JsonValidationError("Логин должен содержать только латинские буквы и цифры")
  val validationPasswordError = JsonValidationError("Пароль должен быть не менее 6 символов, и не должен быть Qwe12345 и 123456. Разрешено использовать только латинские буквы и цифры")
  val validationAddressError = JsonValidationError("Номер дома не может быть отрицательным")
  val validationEmailError = JsonValidationError("Введенные email не соответствует формату: user@test.ru")

  implicit val formatAddress: OFormat[Address] = Json.format[Address]
  implicit val userWrites: Writes[User] = Json.writes[User]

  def toJson(user: User): JsValue = Json.toJson(user)
  def toJsonStr(user: User): String = Json.stringify(toJson(user))

  // Подставляем разные reads сюда явно и запускаем тесты
  def toUser(jsonStr: String): Either[JsError, User] = ???

  //здесь будут validator-ы :-)
  // Правила валидации к User
  // - Login - содержит только латинские буквы и цифры (\w)
  // - Password - не менее 6 символов, не из супер-известных паролей(Qwe12345 и 123456) и состоит из букв и цифр (\w)
  // - Address - номер дома положительный
  // - email - имеет формат email-адреса: address@mail.ru - ^\S+@\S+\.\S+$  или ^\w+@\w+\.\w+$
  val readsLogin: Reads[String] = (__ \ "login").read[String]
  val readPassword: Reads[String] = (__ \ "password").read[String]
  val readsAddress: Reads[Address] = (__ \ "address").read[Address]
  val readsEmail: Reads[String] = (__ \ "email").read[String]

  // reads через for
  // iteration 1 - simple Read
  // iteration 2 - with validation
  val readsUserFor: Reads[User] = ???

  // reads через apply
  // iteration 1 - simple read
  // iteration 2 - with validation
  val readsUserApply = ???
}