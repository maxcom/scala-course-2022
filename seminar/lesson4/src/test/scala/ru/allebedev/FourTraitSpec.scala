package ru.allebedev

import org.specs2.mutable.Specification
import play.api.libs.json.Json
import ru.allebedev.four.{Email, EmailAddress, Person}

class FourTraitSpec extends Specification {

  "Email" should {
    "work!" in {
      val email = Email(Person("allebedev", Some("Lebedev A S")), EmailAddress("mail@mail.com"))
      Json.stringify(Email.toJson(email)) shouldEqual """{"source":{"type":"person","personId":"allebedev","fullname":"Lebedev A S"},"destination":{"type":"email","value":"mail@mail.com"}}"""

      val parsedEmail = Email.toEmail("""{"source":{"type":"person","personId":"allebedev","fullname":"Lebedev A S"},"destination":{"type":"email","value":"mail@mail.com"}}""")
      parsedEmail shouldEqual Email(Person("allebedev", Some("Lebedev A S")), EmailAddress("mail@mail.com"))

    }
  }

}
