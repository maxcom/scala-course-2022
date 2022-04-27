import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route

import scala.io.StdIn
import scala.util.{Failure, Success}

object Main extends App {
  implicit val system = ActorSystem()
  import system.dispatcher

  val userActor = system.actorOf(Props[UserActor])
  val userService = new UserService(userActor)
  val restApi = new RestAPI(userService)

  val route: Route = restApi.routes

  val localhost = "127.0.0.1"
  Http().newServerAt("127.0.0.1", 8000).bind(route)
    .map(_ => println(s"Server bound to $localhost"))
    .onComplete {
      case Failure(exception) =>
        println(s"Unexpected error while binding server: ${exception.getMessage}")
        system.terminate()
      case Success(_) => ()
    }

  StdIn.readLine("Press ENTER to stop\n")
  system.terminate()
}
