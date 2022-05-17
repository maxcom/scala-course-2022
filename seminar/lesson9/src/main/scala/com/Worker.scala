package com

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

import java.util.UUID

object Worker {
  sealed trait WorkerProtocol
  case class Work(id: UUID, msg: String, replyTo: ActorRef[RequestController.RequestResponseProtocol]) extends WorkerProtocol
  case object PrintYourPath extends WorkerProtocol

  def work(): Behavior[WorkerProtocol] = Behaviors.receive[WorkerProtocol] {
    case (ctx, PrintYourPath) =>
      ctx.log.info(s"MyPath is: ${ctx.self.path}")
      Behaviors.same[WorkerProtocol]

    case (ctx, Work(id, msg, replyTo)) =>

      Thread.sleep(10000)

      ctx.log.info(s"${ctx.self.path}: $msg")
      replyTo ! RequestController.Response(id, "processed")
      Behaviors.same[WorkerProtocol]
  }
}
