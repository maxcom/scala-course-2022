import akka.actor.Actor
import scala.collection.mutable.{Map => MutableMap}

import UserActor._

class UserActor extends Actor {
  val users: MutableMap[Int, User] = MutableMap.empty
  var currentId: Int = 0

  private def usersOp(id: Int)(f: => Boolean) = {
    if (users.contains(id)) {
      f
      true
    }
    else false
  }

  override def receive: Receive = {
    case AddUser(user) =>
      users += currentId -> user
      sender() ! currentId
      currentId += 1

    case GetUser(id) =>
      sender() ! users.get(id)

    case GetAllUsers =>
      sender() ! users.values.toList

    case UpdateUser(id, user) =>
      sender() ! usersOp(id)(users.put(id, user).isDefined)

    case RemoveUser(id) =>
      sender() ! usersOp(id)(users.remove(id).isDefined)

  }
}

object UserActor {
  case class AddUser(user: User)
  case class GetUser(id: Int)
  case object GetAllUsers
  case class UpdateUser(id: Int, user: User)
  case class RemoveUser(id: Int)
}
