package seminar

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

//noinspection ScalaDocParserErrorInspection
class TerminatorTest extends AnyFunSpec with Matchers {
  val nameRegex = """[A-Z]{2}\d{3}"""

  it("has a name") {
    new Terminator().name should fullyMatch regex nameRegex
  }

  it("does not change its name") {
    val robot = new Terminator
    val name = robot.name
    robot.name should be(name)
  }

  it("does not have the same name as other robots") {
    new Terminator().name should not be new Terminator().name
  }

  it("can have its name reset") {
    val robot = new Terminator
    val name = robot.name
    robot.reset()
    val name2 = robot.name
    name should not equal name2
    name2 should fullyMatch regex nameRegex
  }

  it("a large number of new instances have unique names") {
    val alreadySet = mutable.HashSet.empty[String]
    for (_ <- 0 until 676000 - 6) { // в предыдущих тестах генерируется 6 имен
      val name = new Terminator().name
      if (alreadySet contains name) {
        fail(s"$name is repeated")
      }
      alreadySet += name
    }
  }
}
