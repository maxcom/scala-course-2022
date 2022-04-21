package com.lesson.six

import cats.data.Validated
import com.lesson.six.models._
import io.circe.Json
import io.circe.syntax.EncoderOps
import org.specs2.mutable.Specification


class Part1Spec extends Specification {
  import Part1._

  "task1" should {
    "parse correct object" in {
      val res = parse("""{ "login": "mylogin" }""")
      res must haveSuperclass[Json]
      res.isObject must beTrue
    }
    "parse correct array" in {
      val res = parse("""{ "login": "mylogin" }""")
      res must haveSuperclass[Json]
      res.isObject must beTrue
    }
    "parse mixed values" in {
      val res = parse("""{
       "login": "mylogin",
       "firstName": null,
       "age": 18,
       "vip": true,
       "cars": [ {"model": "bmw"}, {"age": 10} ]
     }""")
      res must haveSuperclass[Json]
      res.isObject must beTrue
    }
    "parse array input with null objects" in {
      val res = parse("""[ {"model": "bmw"}, {"age": 10}, null ]""")
      res must haveSuperclass[Json]
      res.isArray must beTrue
    }
    "parse array input with different objects" in {
      val res = parse("""[ {"model": "bmw"}, {"age": 10} ]""")
      res must haveSuperclass[Json]
      res.isArray must beTrue
    }
    "parse array input with different elenment types" in {
      val res = parse("""[ {"model": "bmw"}, 10 ]""")
      res must haveSuperclass[Json]
      res.isArray must beTrue
    }
    "not parse broken object" in {
      val res = parse("""[ {"model: "bmw"}, 10 ]""")
      res must haveSuperclass[Json]
      res.isArray must beFalse
    }
  }




  "task1 # Automatic" should {

    val allFieldsString = """{
       "login": "mylogin",
       "password": "passW0rd",
       "firstName": "Vasya",
       "lastName": "Pupkin",
       "age": 20
     }"""
    val allFieldsJson: Json = Json.obj(
      ("login",Json.fromString("mylogin")),
      ("password", Json.fromString("passW0rd")),
      ("firstName", Json.fromString("Vasya")),
      ("lastName", Json.fromString("Pupkin")),
      ("age", Json.fromInt(20))
    )
    val allFieldsData: RegistrationData = RegistrationData(
      login = "mylogin",
      password = "passW0rd",
      firstName = Some("Vasya"),
      lastName = Some("Pupkin"),
      age = Some(20)
    )

    "encode all fields" in {
      encode(allFieldsData)(codecAuto) mustEqual allFieldsJson
    }
    "decode all fields" in {
      decode(allFieldsString)(codecAuto) must beRight(allFieldsData)
    }
  }




  "task2 # SemiAutomatic" should {

    val renamingString: String = """{
       "name": "mylogin",
       "password": "passW0rd"
     }"""
    val renamingJson: Json = Json.obj(
      ("name",Json.fromString("mylogin")),
      ("password", Json.fromString("passW0rd"))
    )
    val renamingData: RegistrationData = RegistrationData(
      login = "mylogin",
      password = "passW0rd",
      firstName = None,
      lastName = None,
      age = None
    )

    "encode with renaming field" in {
      encode(renamingData)(encoderWithRenaming) mustEqual renamingJson
    }
    "decode with renaming field" in {
      decode(renamingString)(decoderWithRenaming) must beRight(renamingData)
    }
  }




  "task3 # Custom" should {

    val allFieldsString = """{
       "login": "mylogin",
       "password": "passW0rd",
       "firstName": "Vasya",
       "lastName": "Pupkin",
       "age": 20
     }"""
    val allFieldsJson: Json = Json.obj(
      ("login",Json.fromString("mylogin")),
      ("password", Json.fromString("passW0rd")),
      ("firstName", Json.fromString("Vasya")),
      ("lastName", Json.fromString("Pupkin")),
      ("age", Json.fromInt(20))
    )
    val allFieldsData: RegistrationData = RegistrationData(
      login = "mylogin",
      password = "passW0rd",
      firstName = Some("Vasya"),
      lastName = Some("Pupkin"),
      age = Some(20)
    )

    val withoutFieldsString: String = """{
       "login": "mylogin",
       "password": "passW0rd"
     }"""
    val withoutFieldsJson: Json = Json.obj(
      ("login",Json.fromString("mylogin")),
      ("password", Json.fromString("passW0rd"))
    )
    val withoutFieldsData: RegistrationData = RegistrationData(
      login = "mylogin",
      password = "passW0rd",
      firstName = None,
      lastName = None,
      age = None
    )

    val emptyInputString = """{
       "login": "",
       "password": "",
       "firstName": "",
       "lastName": ""
     }"""
    val emptyInputData: RegistrationData = RegistrationData(
      login = "",
      password = "",
      firstName = Some(""),
      lastName = Some(""),
      age = None
    )

    "encode with empty field # 1" in {
      encode(allFieldsData)(encoderWithEmptyField) mustEqual allFieldsJson
    }
    "decode with empty field # 1" in {
      decode(allFieldsString)(decoderWithEmptyField) must beRight(allFieldsData)
    }

    "encode with empty field # 3" in {
      encode(withoutFieldsData)(encoderWithEmptyField) mustEqual withoutFieldsJson
    }
    "decode with empty field # 3" in {
      decode(withoutFieldsString)(decoderWithEmptyField) must beRight(withoutFieldsData)
    }

    "not decode empty input" in {
      decode(emptyInputString)(decoderWithEmptyField) must beRight
    }
  }




  "task4 # Validation" should {

    val allFieldsString = """{
       "login": "mylogin",
       "password": "passW0rd",
       "firstName": "Vasya",
       "lastName": "Pupkin",
       "age": 20
     }"""
    val allFieldsJson: Json = Json.obj(
      ("login",Json.fromString("mylogin")),
      ("password", Json.fromString("passW0rd")),
      ("firstName", Json.fromString("Vasya")),
      ("lastName", Json.fromString("Pupkin")),
      ("age", Json.fromInt(20))
    )
    val allFieldsData: RegistrationData = RegistrationData(
      login = "mylogin",
      password = "passW0rd",
      firstName = Some("Vasya"),
      lastName = Some("Pupkin"),
      age = Some(20)
    )

    val withoutFieldsString: String = """{
       "login": "mylogin",
       "password": "passW0rd"
     }"""
    val withoutFieldsJson: Json = Json.obj(
      ("login",Json.fromString("mylogin")),
      ("password", Json.fromString("passW0rd"))
    )
    val withoutFieldsData: RegistrationData = RegistrationData(
      login = "mylogin",
      password = "passW0rd",
      firstName = None,
      lastName = None,
      age = None
    )

    val withEmptyFieldsString: String = """{
       "login": "mylogin",
       "password": "passW0rd",
       "firstName": "",
       "lastName": ""
     }"""
    val withEmptyFieldsJson: Json = Json.obj(
      ("login",Json.fromString("mylogin")),
      ("password", Json.fromString("passW0rd"))
    )
    val withEmptyFieldsData: RegistrationData = RegistrationData(
      login = "mylogin",
      password = "passW0rd",
      firstName = None,
      lastName = None,
      age = None
    )

    val emptyInputString = """{
       "login": "",
       "password": "",
       "firstName": "",
       "lastName": ""
     }"""

    "encode with empty field # 1" in {
      encode(allFieldsData)(encoderWithValidation) mustEqual allFieldsJson
    }
    "decode with empty field # 1" in {
      decode(allFieldsString)(decoderWithValidation) must beRight(allFieldsData)
    }

    "encode with empty field # 3" in {
      encode(withoutFieldsData)(encoderWithValidation) mustEqual withoutFieldsJson
    }
    "decode with empty field # 3" in {
      decode(withoutFieldsString)(decoderWithValidation) must beRight(withoutFieldsData)
    }

    "encode with empty field # 3" in {
      encode(withEmptyFieldsData)(encoderWithValidation) mustEqual withEmptyFieldsJson
    }
    "decode with empty field # 3" in {
      decode(withEmptyFieldsString)(decoderWithValidation) must beRight(withEmptyFieldsData)
    }

    "not decode empty input" in {
      val res = decode(emptyInputString)(decoderWithValidation)
      println(s"DECODE RESULT: $res")
      res must beLeft
    }

    "not decode empty input" in {
      val res = decodeAcc(emptyInputString)(decoderWithValidation)
      println(s"DECODE RESULT: $res")
      res must beLike {
        case Validated.Invalid(errors) => errors.toList must haveSize(2)
      }
    }

  }




  "task5 # Enum" should {
    "encode simple trait" in {
      val field: Field = Field.Login
      field.asJson(encoderField) mustEqual Json.fromString("логин")
    }
    "decode simple trait" in {
      val field = Json.fromString("пароль").as[Field](decoderField)
      field must beRight(Field.Password: Field)
    }
  }

}
