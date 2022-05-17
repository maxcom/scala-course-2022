package com


import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}


import java.util.UUID


object RequestController {
    sealed trait RequestResponseProtocol

    case class SimpleRequest()
    case class Request(id: UUID, query: String, replyTo: ActorRef[ClientActor.ClientProtocol]) extends RequestResponseProtocol
    case class Response(id: UUID, responseMsg: String) extends RequestResponseProtocol
    private case class Finished(rq: Request, responseMsg: String) extends RequestResponseProtocol
    private case class Failed(rq: Request, ex: Throwable) extends RequestResponseProtocol

  def apply(): Behavior[RequestResponseProtocol] = Behaviors.setup[RequestResponseProtocol] { ctx =>
    ???
  }
}
