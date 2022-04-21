package com.lesson.six.models

sealed trait ValidationError { def err: String }

object ValidationError {

  case class FieldNotExist(field: Field) extends ValidationError { val err = s"Поле `${field.name}` не заполнено" }

  case object IncorrectLoginLength extends ValidationError { val err = "Логин должен иметь длину от 5 до 10 символов" }
  case object IncorrectFirstNameLength extends ValidationError { val err = "Имя пользователя должно иметь длину от 5 до 10 символов" }
  case object IncorrectLastNameLength extends ValidationError { val err = "Фамилия пользователя должна иметь длину от 5 до 10 символов" }
  case object IncorrectAge extends ValidationError { val err = "Возраст должен быть в диапазоне от 18 до 60" }

  sealed trait IncorrectPassword extends ValidationError
  object IncorrectPassword {
    case object NumberNotExist extends IncorrectPassword { val err = "Пароль должен содержать хотя бы одну цифру" }
    case object UppercaseLetterNotExist extends IncorrectPassword { val err = "Пароль должен содержать хотя бы одну букву в верхнем регистре" }
    case object LowercaseLetterNotExist extends IncorrectPassword { val err = "Пароль должен содержать хотя бы одну букву в нижнем регистре" }
  }

}
