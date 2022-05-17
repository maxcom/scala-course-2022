package com

import akka.actor.testkit.typed.scaladsl.{ActorTestKit, ActorTestKitBase}
import com.{ClientActor, RequestController}
import org.scalatest.{MustMatchers, WordSpecLike}

import java.util.UUID
import scala.concurrent.duration.DurationInt

class RequestControllerSpec extends ActorTestKitBase(ActorTestKit(ActorTestKitBase.testNameFromCallStack())) with WordSpecLike with MustMatchers {
  val actor = testKit.spawn(RequestController(), "RequestController-test")
  val probe = testKit.createTestProbe[ClientActor.ClientProtocol]()

  "RequestController" should {
    "send request to worker and return result" in {
      val requestUUID: UUID = UUID.randomUUID()
      val messageStr = "message #0000"
      actor ! RequestController.Request(requestUUID, messageStr, probe.ref)
      probe.expectMessage(10.seconds, ClientActor.SuccessResponse(requestUUID))

      val requestUUID2: UUID = UUID.randomUUID()
      val messageStr2 = "message #1111"
      actor ! RequestController.Request(requestUUID2, messageStr2, probe.ref)
      probe.expectMessage(10.seconds, ClientActor.SuccessResponse(requestUUID2))
    }
  }

  override protected def afterAll(): Unit = {
    testKit.shutdownTestKit()
  }
}
