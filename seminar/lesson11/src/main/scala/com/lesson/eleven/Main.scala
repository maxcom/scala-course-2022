package com.lesson.eleven

import cats.effect._
import com.comcast.ip4s._
import org.http4s.server.Router
import org.http4s.ember.server.EmberServerBuilder
import org.http4s._
import org.http4s.implicits._

object Main extends IOApp.Simple {


  val routes: HttpApp[IO] = Router(
    "/" -> HttpRoutes.empty[IO]
  ).orNotFound

  //curl -x GET http://localhost:8080/task1/hello
  val server: ResourceIO[org.http4s.server.Server] =
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(routes)
      .build

  val run = server.use(_ => IO.never)

}