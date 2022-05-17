package com

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

import java.util.UUID

object ClientActor {
  sealed trait ClientProtocol

  case class SendRequest(msg: String) extends ClientProtocol
  case class SuccessResponse(id: UUID) extends ClientProtocol
  case class FailureResponse(id: UUID, failedMsg: String) extends ClientProtocol

  def apply(): Behavior[ClientProtocol] = Behaviors.setup[ClientProtocol] { ctx =>
    ???
  }
}
