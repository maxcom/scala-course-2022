package ru.allebedev.first

import play.api.libs.functional.syntax._

case class Attraction(name: String, location: AttractionLocation, info: Option[AttractionInfo])

object Attraction {

  def toJsonStr(obj: Attraction): String = ???

  def fromJsonStr(json: String): Attraction = ???

}