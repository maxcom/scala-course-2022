package ru.allebedev

import akka.actor.testkit.typed.scaladsl.{ActorTestKit, ActorTestKitBase}
import org.scalatest.{MustMatchers, WordSpecLike}
import ru.allebedev.core.FakeDbService
import ru.allebedev.FutureStashActor._
import scala.concurrent.duration._

class FutureStashActorSpec extends ActorTestKitBase(ActorTestKit(ActorTestKitBase.testNameFromCallStack())) with WordSpecLike with MustMatchers {

  "FutureStashActor" should {

    "initial with future" in {
      val actor = testKit.spawn(FutureStashActor.behavior(FakeDbService.apply), "future-test")
      val probe = testKit.createTestProbe[Seq[String]]()
      actor ! PutData("four")
      actor ! GetData(probe.ref)
      probe.expectMessage(10.seconds, Seq("four", "first", "second", "third"))
      actor ! PutData("five")
      actor ! GetData(probe.ref)
      probe.expectMessage(Seq("five", "four", "first", "second", "third"))
    }

  }

  override protected def afterAll(): Unit = {
    testKit.shutdownTestKit()
  }

}
