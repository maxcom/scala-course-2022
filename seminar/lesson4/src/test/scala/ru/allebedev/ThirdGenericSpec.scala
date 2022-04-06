package ru.allebedev

import org.specs2.mutable.Specification
import ru.allebedev.third.{AllThing, AllThingsFinderRequest, Book, BookDict}

class ThirdGenericSpec extends Specification {

  "Book" should {
    "correct translate names" in {
      implicit val translate: String => String = (key: String) => BookDict.DICTIONARY.getOrElse(key, throw new Exception("wrong key!"))
      val gameOfThrones = Book("#gameOfThrones", "fantasy", 600)
      Book.toJsonStr(gameOfThrones) shouldEqual """{"name":"A Game of Thrones","style":"fantasy","size":600}"""
      val duna = Book("#duna", "fantasy", 666)
      Book.toJsonStr(duna) shouldEqual """{"name":"Dune: Part One","style":"fantasy","size":666}"""
    }
  }

  "AllThingsFinderRequest" should {
    "used generic" in {
      val intRequest = AllThingsFinderRequest.toJsonStr[String](AllThingsFinderRequest("giveThemAll", 20))
      intRequest shouldEqual """{"body":"giveThemAll","limit":20}"""
//      val allRequest = AllThingsFinderRequest.toJsonStr[AllThing](AllThingsFinderRequest(AllThing(4, 2), 20))(???)
//      allRequest shouldEqual """{"body":{"a":4,"b":2},"limit":20}"""
    }

  }


}
