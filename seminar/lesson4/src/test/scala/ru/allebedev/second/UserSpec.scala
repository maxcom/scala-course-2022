package ru.allebedev.second

import org.specs2.mutable.Specification
import play.api.libs.json.JsError

class UserSpec extends Specification {
  val user1Str = """{"login":"user1","password":"XSW123","address":{"street":"main street","houseNumber":66},"email":"user1@mail.ru"}"""
  val user2Str = """{"login":"user#2","password":"pwd","address":{"street":"main street","houseNumber":-1},"email":"user2@mail"}"""


  "Validate" should {
    "serialized and deserialized successfully" in {
      val user1: User = User("user1", "XSW123", Address("main street", 66), "user1@mail.ru")
      User.toUser(user1Str) must beEqualTo(Right(user1))
      User.toJsonStr(user1) must beEqualTo(user1Str)
    }

    "check fields" in {
      User.toUser(user2Str) match {
        case Right(user) =>
          "should not return user with incorrect fields" in {
            failure("User should be invalid, but it's parsed successfully")
          }
        case Left(JsError(errorSeq)) =>
          "should detect if login is incorrect" in {
            errorSeq.flatMap { case (parh, error) => error } must contain(User.validationLoginError)
          }
          "should detect if password is incorrect" in {
            errorSeq.flatMap { case (parh, error) => error } must contain(User.validationPasswordError)
          }

          "should detect if address is incorrect" in {
            errorSeq.flatMap { case (parh, error) => error } must contain(User.validationAddressError)
          }

          "should detect if email is incorrect" in {
            errorSeq.flatMap { case (parh, error) => error } must contain(User.validationEmailError)
          }

          "should find all errors" in {
            errorSeq.size must beEqualTo(4)
          }
      }
    }
  }
}
