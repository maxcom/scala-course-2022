package ru.allebedev

import org.specs2.mutable.Specification
import ru.allebedev.first.{Attraction, AttractionInfo, AttractionLocation, People}

class FirstCustomSpec extends Specification {

  "People" should {

    "used writes " in {
      People.toJsonStr(People("Nik", 18)) shouldEqual """{"name":"Nik","age":18}"""
    }

    "used reads " in {
      People.fromJsonStr(""" {"name": "Nik", "age": 18} """) shouldEqual People("Nik", 18)
    }

  }

  "Attraction" should {

    "used custom writes with Option" in {
      val jsonStr = Attraction.toJsonStr(Attraction("Big Ban", AttractionLocation(1.1, 2.2), None))
      jsonStr shouldEqual """{"name":"Big Ban","latitude":1.1,"longitude":2.2}"""
    }

    "used custom reads with Option" in {
      val attraction = Attraction.fromJsonStr("""{"name":"Big Ban","latitude":1.1,"longitude":2.2}""")
      attraction shouldEqual Attraction("Big Ban", AttractionLocation(1.1, 2.2), None)
    }

    "used custom writes" in {
      val jsonStr = Attraction.toJsonStr(Attraction("Big Ban", AttractionLocation(1.1, 2.2), Some(AttractionInfo("Big Ban descr", 100500))))
      jsonStr shouldEqual """{"name":"Big Ban","latitude":1.1,"longitude":2.2,"information":{"description":"Big Ban descr","age":100500}}"""
    }

    "used custom reads" in {
      val attraction = Attraction.fromJsonStr("""{"name":"Big Ban","latitude":1.1,"longitude":2.2,"information":{"description":"Big Ban descr","age":100500}}""")
      attraction shouldEqual Attraction("Big Ban", AttractionLocation(1.1, 2.2), Some(AttractionInfo("Big Ban descr", 100500)))
    }

  }

}
