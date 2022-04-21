package com.lesson.six

import com.lesson.six.models._
import io.circe._
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.syntax._
import cats.syntax.apply._

object Part1 {

  ////////////////////////////////////////////////////////////
  // ЗАДАНИЕ 1:
  // Парсинг, авто-кодеки
  ////////////////////////////////////////////////////////////
  def parse(input: String): Json = ???

  def encoderAuto: Encoder[RegistrationData] = deriveEncoder
  def decoderAuto: Decoder[RegistrationData] = deriveDecoder
  def codecAuto: Codec[RegistrationData] = ???

  def decode(input: String)
            (implicit decoder: Decoder[RegistrationData]): Decoder.Result[RegistrationData] = ???

  def decodeAcc(input: String)
            (implicit decoder: Decoder[RegistrationData]): Decoder.AccumulatingResult[RegistrationData] = ???

  def encode(data: RegistrationData)
            (implicit encoder: Encoder[RegistrationData]): Json = ???

  ////////////////////////////////////////////////////////////
  // ЗАДАНИЕ 2:
  // Пишем кодеки для кейс-класса: semi-automatic.
  // Переименовываем поле login в name
  ////////////////////////////////////////////////////////////
  def decoderWithRenaming: Decoder[RegistrationData] = ???
  def encoderWithRenaming: Encoder[RegistrationData] = ???

  ////////////////////////////////////////////////////////////
  // ЗАДАНИЕ 3:
  // Пишем кодеки для кейс-класса: custom.
  // Отсутствующие поля или null должны превращаться в None
  ////////////////////////////////////////////////////////////
  def decoderWithEmptyField: Decoder[RegistrationData] = ???

  def encoderWithEmptyField: Encoder[RegistrationData] = ???

  
  ////////////////////////////////////////////////////////////
  // ЗАДАНИЕ 4:
  // Добавляем валидации: пустые строки должны превращаться в null
  // Логин и пароль - обязательно не пустые
  ////////////////////////////////////////////////////////////
  def decoderWithValidation: Decoder[RegistrationData] = ???

  def encoderWithValidation: Encoder[RegistrationData] = ???

  ////////////////////////////////////////////////////////////
  // ЗАДАНИЕ 5:
  // Пишем кодеки для простого ENUM (sealed trait)
  ////////////////////////////////////////////////////////////
  def encoderField: Encoder[Field] = ???
  def decoderField: Decoder[Field] = ???

}

