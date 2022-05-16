package ru.allebedev

import akka.actor.testkit.typed.scaladsl.{ActorTestKit, ActorTestKitBase}
import org.scalatest.{MustMatchers, WordSpecLike}
import ru.allebedev.SimpleActor._

class SimpleActorSpec extends ActorTestKitBase(ActorTestKit(ActorTestKitBase.testNameFromCallStack())) with WordSpecLike with MustMatchers {

  "SimpleActor" should {

    "put and get msg" in {
      val actor = testKit.spawn(SimpleActor.behavior(), "simple-test")
      val probe = testKit.createTestProbe[Seq[String]]()
      actor ! PutMsg("first")
      actor ! PutMsg("second")
      actor ! GetMsg(probe.ref)
      probe.expectMessage(Seq("second", "first"))
    }

  }

  override protected def afterAll(): Unit = {
    testKit.shutdownTestKit()
  }

}
