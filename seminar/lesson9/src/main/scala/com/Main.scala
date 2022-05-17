package com

import akka.actor.typed.{ActorRef, ActorSystem}
import akka.util.Timeout

import scala.concurrent.duration.DurationInt


/**
 * Схема взаимодействия
 * Client -> RequestController -> Worker
 *
 * Задание 1:
 *   1.1 Создать ActorSystem
 *   1.2 Создать акторы, согласно схеме взаимодействия:
 *   - Создать RequestController
 *   - Создать Client
 *   1.3 - Создать Worker (его parent - RequestController)
 *   Задание 2:
 *   - ask pattern - Client ? RequestController ? worker
 *   Задание 3:
 *   - router pattern - много worker-ов
 */

// https://doc.akka.io/docs/akka/current/typed/guide/tutorial_1.html
// https://doc.akka.io/docs/akka/current/typed/guide/tutorial_2.html
object Main extends App {

  // SpawnProtocol
  // - https://maxcom.github.io/scala-course-2022/slides/day8.html#/32
  // - https://doc.akka.io/docs/akka/current/typed/actor-lifecycle.html#spawnprotocol

  // вариант 1 - root actor
  def createWithRootActor() = {
    // Первый подвариант - создаем actor использующий SpawnProtocol

    // Второй подвариант - если нужен root-овый Actor уже с протоколом, куда нужно что-то передать

  }

  // вариант 2 - SpawnProtocol - создаём корневой актор с помощью SpawnProtocol, который умеет spawn-нить другие акторы
  def createWithSpawnProtocol() = {
    implicit val timeout: Timeout = Timeout(3.seconds)

  }


  def createFromClassic() = {
    // вариант 3 - конвертация из classic системы. Используется при миграции с classic на Typed
    import akka.actor.typed.scaladsl.adapter.ClassicActorSystemOps
    import akka.{actor => classic}

    val systemClassic: classic.ActorSystem = classic.ActorSystem("system")
    val systemTyped: ActorSystem[Nothing] = systemClassic.toTyped

    //val requestController: ActorRef[RequestController.RequestResponseProtocol] = systemClassic.spawn[RequestController.RequestResponseProtocol](RequestController(), name = "request-controller")
    //val client: ActorRef[ClientActor.ClientProtocol] = systemClassic.spawn[ClientActor.ClientProtocol](ClientActor(requestController), name = "client-1")

    systemTyped
  }

  createWithRootActor()
}
