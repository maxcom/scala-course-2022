case class User(name: String, sex: Gender, age: Int)

sealed trait Gender {
  def name: String
}
case object Male extends Gender {
  val name: String = "male"
}
case object Female extends Gender {
  val name: String = "female"
}
