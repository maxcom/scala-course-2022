package ru.allebedev

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}
import ru.allebedev.core.FakeDbService

import scala.util.{Failure, Success, Try}

object FutureStashActor {

  sealed trait FutureProtocol

  def behavior(service: FakeDbService): Behavior[FutureProtocol] = ???


}
