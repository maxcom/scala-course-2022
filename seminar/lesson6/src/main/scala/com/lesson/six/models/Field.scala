package com.lesson.six.models

sealed trait Field { def name: String }

object Field {

  case object Login extends Field { val name = "логин" }
  case object Password extends Field { val name = "пароль" }

}