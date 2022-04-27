import akka.actor.Props
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._
import io.circe.{Decoder, Encoder}
import org.scalatest.matchers.must._
import org.scalatest.wordspec.AnyWordSpec

class RestApiSpec extends AnyWordSpec
  with Matchers
  with ScalatestRouteTest
  with FailFastCirceSupport {

  implicit def encoderGenderField: Encoder[Gender] = Encoder.encodeString.contramap(_.name)
  implicit def decoderGenderField: Decoder[Gender] = Decoder.decodeString.map {
    case Male.name   => Male
    case Female.name => Female
  }

  val userActor = system.actorOf(Props[UserActor])
  val userService = new UserService(userActor)
  val routes = (new RestAPI(userService)).routes
  val newUser = User("Test", Male, 17)


  "Rest API" must {
    "create user" in {
      ???
    }

    "get user" in {
      ???
    }
  }
  // И так далее
}
