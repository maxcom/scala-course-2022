import akka.event.Logging
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.DebuggingDirectives
import akka.http.scaladsl.server._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._
import io.circe.{Decoder, Encoder}

import scala.concurrent.ExecutionContext

class RestAPI(userService: UserService)(implicit ec: ExecutionContext) extends FailFastCirceSupport {

  implicit def encoderGenderField: Encoder[Gender] = Encoder.encodeString.contramap(_.name)
  implicit def decoderGenderField: Decoder[Gender] = Decoder.decodeString.map {
    case Male.name   => Male
    case Female.name => Female
  }

  /*
    Задание 1:
    Написать роут для добавления пользователя
    POST /users/create

    Content-Type: application/json
    Пример джейсона:

    {
	  "name":"John",
	  "sex": "male",
	  "age": 27
    }
   */
  def createUserRoute: Route = ???

  /*
    Задание 2:
    Написать роут для получения всех пользователей
    GET /users
   */
  def getAllUsersRoute: Route = ???



  /*
    Задание 3:
    Написать роут получения пользователя по id через параметр
    Если пользователя в базе нет, вернуть 404 с кастомным текстом
    GET /users/get?id={id}
   */
  def getUserRoute: Route = ???

  /*
    Задание 4:
    Написать роут обновления пользователя по id. Id должен быть частью роута
    Если пользователя в базе нет, вернуть 404 с кастомным текстом
    PUT /users/update/id + json
   */
  def updateUserRoute: Route = ???

  /*
    Задание 5:
    Написать роут удаления пользователя по id через параметр и указать его в роуте
    Если пользователя в базе нет, вернуть 404 с кастомным текстом
    DELETE /users/remove/id
   */
  def deleteUserRoute: Route = ???

  /*
    Задание 6:
    Объяснить что делает данный роутинг и исправить ошибку
   */

  def getOrPutPath =
    pathPrefix("test") {
      pathEndOrSingleSlash {
        get {
          complete(StatusCodes.OK)
        }
        post {
          complete(StatusCodes.Forbidden)
        }
      }
    }

  /*
    Задание 7:
    Написать RejectionHandler'ы:
    - верхнеуровневый, который возвращает BadRequest с кастомным текстом
    - нижнеуровневый (навесить на роут /remove), который возвращает Forbidden при попытке
      использовать другие REST методы
   */

  def badRequestHandler: RejectionHandler = ???

  def forbiddenHandler: RejectionHandler = ???

  /*
    (Опционально) Задание 8:
    Написать RejectionHandler на MissingQueryParamRejection и MethodRejection
    и изменить текст ошибки
   */

  /*
    Задание 9:
    Завернуть exception из methodWithException и вернуть ServiceUnavailable с текстом из ошибки
   */

  def methodWithExceptionRoute: Route = ???

  def exceptionHandler: ExceptionHandler = ???

  /*
    Задание 10:
    Написать директиву, которая логирует все реквесты и респонсы и подмешать ее ко всем роутам
    Подсказка: Использовать инструменты из akka.http.scaladsl.server.directives.DebuggingDirectives
   */

  def logExtractorDirective: Directive0 = ???

  def routes: Route =
    pathPrefix("users") {
      createUserRoute ~ getAllUsersRoute ~ getUserRoute ~ updateUserRoute ~ deleteUserRoute
    }

}
