package com.lesson.six

import cats.data.{NonEmptyList, Validated, ValidatedNel}
import com.lesson.six.models.ValidationError._
import com.lesson.six.models._
import cats.implicits._

import scala.util.{Failure, Success, Try}

class Part2(webForm: InputWebForm) {
  import webForm._

  def toRegistrationDataUnsafe: RegistrationData =
    RegistrationData(
      login = login,
      password = password,
      firstName = Option.when(firstName.nonEmpty)(firstName),
      lastName = Option.when(lastName.nonEmpty)(lastName),
      age = Option.when(age.nonEmpty)(age.toInt)
    )

  ////////////////////////////////////////////////////////////
  // ЗАДАНИЕ 1:
  // Делаем проверки всех необходимых полей и возвращает Boolean.
  ////////////////////////////////////////////////////////////

  // Имя пользователя должно иметь длину от 5 до 10 символов
  private def isCorrectFirstNameLength: Boolean = ???

  // Фамилия пользователя должна иметь длину от 5 до 10 символов
  private def isCorrectLastNameLength: Boolean = ???

  // Возраст должен быть в диапазоне от 18 до 60
  private def isCorrectAge: Boolean = ???

  // Логин должен быть заполнен
  private def loginExists: Boolean = ???
  // Логин должен иметь длину от 5 до 10 символов
  private def isCorrectLoginLength: Boolean = ???
  // Все проверки логина вместе:
  private def isCorrectLogin: Boolean = ???

  // Пароль должен быть заполнен
  private def passwordExists: Boolean = ???
  // Пароль должен содержать хотя бы одну цифру
  private def passwordContainsNumber: Boolean = ???
  // Пароль должен содержать хотя бы одну букву в верхнем регистре
  private def passwordContainsUppercase: Boolean = ???
  // Пароль должен содержать хотя бы одну букву в нижнем регистре
  private def passwordContainsLowercase: Boolean = ???
  // Все проверки пароля вместе:
  private def isCorrectPassword: Boolean = ???

  // Собираем все проверки вместе:
  def isCorrectFields: Boolean = ???



  ////////////////////////////////////////////////////////////
  // Задание 2:
  // Проверка должна возвращать содержательную ошибку
  ////////////////////////////////////////////////////////////
  def findException: Option[ValidationError] = ???

  ////////////////////////////////////////////////////////////
  // Задание 3:
  // Должны возвращаться все найденные ошибки, а не только первая
  ////////////////////////////////////////////////////////////
  def getAllExceptions: List[ValidationError] = ???

  def findAllExceptions: Option[NonEmptyList[ValidationError]] = ???

  ////////////////////////////////////////////////////////////
  // Задание 4:
  // Проверка должна возвращать результат или ошибки валидации
  ////////////////////////////////////////////////////////////

  def getResultOrException: Either[ValidationError, RegistrationData] = ???

  def getResultOrExceptionsUnsafe: Either[List[ValidationError], RegistrationData] = ???

  def getResultOrExceptions: Either[NonEmptyList[ValidationError], RegistrationData] = ???

  ////////////////////////////////////////////////////////////
  // Задание 5:
  // Заменяем Either на Validated
  ////////////////////////////////////////////////////////////

  def validate: Validated[NonEmptyList[ValidationError], RegistrationData] = ???


  type ValidationResult[A] = ValidatedNel[ValidationError, A]

  // А теперь тоже самое, но без переиспользований: разрешены только функции из задания 1
  def validateResult: ValidationResult[RegistrationData] = ???


}
