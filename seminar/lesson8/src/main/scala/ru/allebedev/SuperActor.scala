package ru.allebedev

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior, SupervisorStrategy}
import ru.allebedev.core.{DbFatalExeption, FakeDbService}

import scala.util.{Failure, Success, Try}

object SuperActor {

  sealed trait SuperProtocol

  def behavior(service: FakeDbService): Behavior[SuperProtocol] = ???

}
