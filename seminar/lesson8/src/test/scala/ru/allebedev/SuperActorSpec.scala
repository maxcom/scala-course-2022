package ru.allebedev

import akka.actor.testkit.typed.scaladsl.{ActorTestKit, ActorTestKitBase}
import org.scalatest.{MustMatchers, WordSpecLike}
import ru.allebedev.SuperActor._
import ru.allebedev.core.FakeDbService

class SuperActorSpec extends ActorTestKitBase(ActorTestKit(ActorTestKitBase.testNameFromCallStack())) with WordSpecLike with MustMatchers {

  "SuperActor" should {

    "restart and stop" in {
      val actor = testKit.spawn(SuperActor.behavior(FakeDbService.apply), "super-test")
      val probe = testKit.createTestProbe[Seq[String]]()

      actor ! Refresh
      probe.expectNoMessage()
      actor ! GetData(probe.ref)
      probe.expectMessage(Seq("first", "second", "third"))

      actor ! RefreshWithError
      probe.expectNoMessage()
      actor ! GetData(probe.ref)
      probe.expectMessage(Seq.empty)

      actor ! ThrowError
      probe.expectTerminated(actor)

    }

  }

  override protected def afterAll(): Unit = {
    testKit.shutdownTestKit()
  }

}
