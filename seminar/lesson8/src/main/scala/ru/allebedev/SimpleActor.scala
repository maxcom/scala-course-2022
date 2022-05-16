package ru.allebedev

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}
import ru.allebedev.core.FakeDbService

import scala.util.{Failure, Success}

object SimpleActor {

  sealed trait SimpleProtocol

  def behavior(list: Seq[String] = Seq.empty): Behavior[SimpleProtocol] = ???

}
