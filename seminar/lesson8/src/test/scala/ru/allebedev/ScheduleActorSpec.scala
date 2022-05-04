package ru.allebedev

import akka.actor.testkit.typed.scaladsl.{ActorTestKit, ActorTestKitBase}
import org.mockito.Mockito
import org.scalatest.{MustMatchers, WordSpecLike}
import org.scalatestplus.mockito.MockitoSugar
import ru.allebedev.core.{DataForStamp, FakeDbService}
import org.mockito.Matchers.any
import ru.allebedev.ScheduleActor.StampData

import scala.util.Random

class ScheduleActorSpec extends ActorTestKitBase(ActorTestKit(ActorTestKitBase.testNameFromCallStack()))
  with WordSpecLike
  with MockitoSugar
  with MustMatchers {

  "ScheduleActor" should {

    "work" in {
      val list: Seq[DataForStamp] = Seq.fill(50)(DataForStamp(Random.nextString(10)))
      val fakeService = FakeDbService.apply
      val spyService = Mockito.spy(fakeService)
      val actor = testKit.spawn(ScheduleActor.behavior(spyService), "schedule-test")
      actor ! StampData(list)
      Thread.sleep(15000)
      Mockito.verify(spyService, Mockito.times(1)).stamp(any[Seq[DataForStamp]])
      Thread.sleep(10000)
      Mockito.verify(spyService, Mockito.times(2)).stamp(any[Seq[DataForStamp]])
    }

  }

  override protected def afterAll(): Unit = {
    testKit.shutdownTestKit()
  }

}
