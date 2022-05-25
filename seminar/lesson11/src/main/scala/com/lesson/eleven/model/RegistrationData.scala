package com.lesson.eleven.model

import cats.syntax.apply._
import io.circe.{Decoder, Encoder, Json}

case class RegistrationData(login: String,
                            password: String,
                            firstName: Option[String],
                            lastName: Option[String],
                            age: Option[Int])


object RegistrationData {

  implicit val decoderWithValidation: Decoder[RegistrationData] = (
    Decoder[String].at("login")
      .ensure(_.nonEmpty, "login should not be empty"),
    Decoder.decodeString.at("password")
      .ensure(_.nonEmpty, "password should not be empty"),
    Decoder.instance(
      _.downField("firstName").as[Option[String]].map(_.filter(_.nonEmpty))
    ),
    Decoder.instance(
      _.get[Option[String]]("lastName").map(_.filter(_.nonEmpty))
    ),
    Decoder.instance( _.get[Option[Int]]("age") )
  ).mapN(RegistrationData.apply)

  implicit val encoderWithValidation: Encoder[RegistrationData] = (d: RegistrationData) =>
    Json.obj(
      ("login", Json.fromString(d.login)),
      ("password", Json.fromString(d.password)),
      ("firstName", d.firstName.fold(Json.Null)(Json.fromString)),
      ("lastName", d.lastName.fold(Json.Null)(Json.fromString)),
      ("age", d.age.fold(Json.Null)(Json.fromInt))
    ).mapObject(_.filter(!_._2.isNull))

}
