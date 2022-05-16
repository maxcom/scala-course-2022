package ru.allebedev

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import ru.allebedev.core.{DataForStamp, FakeDbService}

import scala.concurrent.duration._
import scala.util.{Failure, Success}

object ScheduleActor {

  sealed trait SchProtocol

  def behavior(service: FakeDbService): Behavior[SchProtocol] = ???

}
