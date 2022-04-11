package ru.allebedev.third

import play.api.libs.functional.syntax._

case class Book(nameKey: String, style: String, size: Int)

object Book {

  def toJsonStr(obj: Book)(implicit translate: String => String): String = ???

}
