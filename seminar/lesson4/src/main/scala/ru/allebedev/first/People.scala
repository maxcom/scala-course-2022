package ru.allebedev.first

case class People(name: String, age: Int)

object People {

  def toJsonStr(obj: People): String = ???

  def fromJsonStr(json: String): People = ???

}
