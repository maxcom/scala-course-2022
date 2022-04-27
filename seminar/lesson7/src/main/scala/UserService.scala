import UserActor._
import akka.actor.ActorRef
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.Future
import scala.language.postfixOps

class UserService(userActor: ActorRef) {
  implicit val timeout: Timeout = Timeout(2 seconds)

  def addUser(user: User): Future[Int]                 = (userActor ? AddUser(user)).mapTo[Int]
  def getUser(id: Int): Future[Option[User]]           = (userActor ? GetUser(id)).mapTo[Option[User]]
  def getAllUsers: Future[List[User]]                  = (userActor ? GetAllUsers).mapTo[List[User]]
  def updateUser(id: Int, user: User): Future[Boolean] = (userActor ? UpdateUser(id, user)).mapTo[Boolean]
  def removeUser(id: Int): Future[Boolean]             = (userActor ? RemoveUser(id)).mapTo[Boolean]
  def methodWithException: String = throw new RuntimeException("Сервер перегружен")
}
