package ru.allebedev.third

import play.api.libs.json.{Reads, Writes}
import play.api.libs.functional.syntax._

case class AllThingsFinderRequest[T](body: T, limit: Int)

object AllThingsFinderRequest {

  def toJsonStr[T](obj: AllThingsFinderRequest[T])(implicit writes: Writes[T]): String = ???

  def fromJsonStr[T](json: String)(implicit reads: Reads[T]): AllThingsFinderRequest[T] = ???

}