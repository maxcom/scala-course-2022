package com.lesson.six

import cats.data.{NonEmptyList, Validated}
import com.lesson.six.models._
import org.specs2.mutable.Specification

class Part2Spec extends Specification {
  import Part2TestData._

  "isCorrectFields" should {
    "detect correctInput" in {
      correctInput.isCorrectFields must beTrue
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.isCorrectFields must beTrue
    }
    "detect emptyInput" in {
      emptyInput.isCorrectFields must beFalse
    }
    "detect incorrectInput" in {
      incorrectInput.isCorrectFields must beFalse
    }
  }

  "findException" should {
    "detect correctInput" in {
      correctInput.findException must beNone
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.findException must beNone
    }
    "detect emptyInput" in {
      emptyInput.findException must beSome.which(emptyInputAllErrors.contains)
    }
    "detect incorrectInput" in {
      incorrectInput.findException must beSome.which(incorrectInputAllErrors.contains)
    }
  }

  "getAllExceptions" should {
    "detect correctInput" in {
      correctInput.getAllExceptions must beEmpty[List[ValidationError]]
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.getAllExceptions must beEmpty[List[ValidationError]]
    }
    "detect emptyInput" in {
      emptyInput.getAllExceptions must containTheSameElementsAs(emptyInputAllErrors)
    }
    "detect incorrectInput" in {
      incorrectInput.getAllExceptions must containTheSameElementsAs(incorrectInputAllErrors)
    }
  }

  "findAllExceptions" should {
    "detect correctInput" in {
      correctInput.findAllExceptions must beNone
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.findAllExceptions must beNone
    }
    "detect emptyInput" in {
      emptyInput.findAllExceptions must beSome[NonEmptyList[ValidationError]].which(
        _.toList must containTheSameElementsAs(emptyInputAllErrors)
      )
    }
    "detect incorrectInput" in {
      incorrectInput.findAllExceptions must beSome[NonEmptyList[ValidationError]].which(
        _.toList must containTheSameElementsAs[ValidationError](incorrectInputAllErrors)
      )
    }
  }

  "getResultOrException" should {
    "detect correctInput" in {
      correctInput.getResultOrException must beRight(correctInputResult)
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.getResultOrException must beRight(correctInputAllFieldsResult)
    }
    "detect emptyInput" in {
      emptyInput.getResultOrException must beLeft.which(emptyInputAllErrors.contains)
    }
    "detect incorrectInput" in {
      incorrectInput.getResultOrException must beLeft.which(incorrectInputAllErrors.contains)
    }
  }

  "getResultOrExceptionsUnsafe" should {
    "detect correctInput" in {
      correctInput.getResultOrExceptionsUnsafe must beRight(correctInputResult)
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.getResultOrExceptionsUnsafe must beRight(correctInputAllFieldsResult)
    }
    "detect emptyInput" in {
      emptyInput.getResultOrExceptionsUnsafe must beLeft[List[ValidationError]].which(
        _ must containTheSameElementsAs(emptyInputAllErrors)
      )
    }
    "detect incorrectInput" in {
      incorrectInput.getResultOrExceptionsUnsafe must beLeft[List[ValidationError]].which(
        _ must containTheSameElementsAs(incorrectInputAllErrors)
      )
    }
  }

  "getResultOrExceptions" should {
    "detect correctInput" in {
      correctInput.getResultOrExceptions must beRight(correctInputResult)
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.getResultOrExceptions must beRight(correctInputAllFieldsResult)
    }
    "detect emptyInput" in {
      emptyInput.getResultOrExceptions must beLeft[NonEmptyList[ValidationError]].which(
        _.toList must containTheSameElementsAs(emptyInputAllErrors)
      )
    }
    "detect incorrectInput" in {
      incorrectInput.getResultOrExceptions must beLeft[NonEmptyList[ValidationError]].which(
        _.toList must containTheSameElementsAs[ValidationError](incorrectInputAllErrors)
      )
    }
  }

  "validate" should {
    "detect correctInput" in {
      correctInput.validate must beEqualTo(
        Validated.Valid(correctInputResult)
      )
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.validate must beEqualTo(
        Validated.Valid(correctInputAllFieldsResult)
      )
    }
    "detect emptyInput" in {
      emptyInput.validate must beLike {
        case Validated.Invalid(res) => res.toList must containTheSameElementsAs(emptyInputAllErrors)
      }
    }
    "detect incorrectInput" in {
      incorrectInput.validate must beLike {
        case Validated.Invalid(res) => res.toList must containTheSameElementsAs(incorrectInputAllErrors)
      }
    }
  }

  "validateResult" should {
    "detect correctInput" in {
      correctInput.validateResult must beEqualTo(
        Validated.Valid(correctInputResult)
      )
    }
    "detect correctInputAllFields" in {
      correctInputAllFields.validateResult must beEqualTo(
        Validated.Valid(correctInputAllFieldsResult)
      )
    }
    "detect emptyInput" in {
      emptyInput.validateResult must beLike {
        case Validated.Invalid(res) => res.toList must containTheSameElementsAs(emptyInputAllErrors)
      }
    }
    "detect incorrectInput" in {
      incorrectInput.validateResult must beLike {
        case Validated.Invalid(res) => res.toList must containTheSameElementsAs(incorrectInputAllErrors)
      }
    }
  }

}

object Part2TestData {

  val correctInput = new Part2( InputWebForm(
    login = "mylogin",
    password = "passW0rd",
    firstName = "",
    lastName = "",
    age = ""
  ) )
  val correctInputResult = RegistrationData(
    login = "mylogin",
    password = "passW0rd",
    firstName = None,
    lastName = None,
    age = None
  )

  val correctInputAllFields = new Part2( InputWebForm(
    login = "mylogin",
    password = "passW0rd",
    firstName = "Vasya",
    lastName = "Pupkin",
    age = "20"
  ) )
  val correctInputAllFieldsResult = RegistrationData(
    login = "mylogin",
    password = "passW0rd",
    firstName = Some("Vasya"),
    lastName = Some("Pupkin"),
    age = Some(20)
  )

  val emptyInput = new Part2( InputWebForm(
    login = "",
    password = "",
    firstName = "",
    lastName = "",
    age = ""
  ) )
  val emptyInputAllErrors = Seq(
    ValidationError.FieldNotExist(Field.Login),
    ValidationError.FieldNotExist(Field.Password)
  )

  val incorrectInput = new Part2( InputWebForm(
    login = "lgn",
    password = "pass",
    firstName = "bla-bla-bla",
    lastName = "tro-lo-lo-lo",
    age = "dont know"
  ) )
  val incorrectInputAllErrors = Seq(
    ValidationError.IncorrectFirstNameLength,
    ValidationError.IncorrectLastNameLength,
    ValidationError.IncorrectLoginLength,
    ValidationError.IncorrectAge,
    ValidationError.IncorrectPassword.NumberNotExist,
    ValidationError.IncorrectPassword.UppercaseLetterNotExist
  )

}