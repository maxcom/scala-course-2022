package seminar

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.io.ByteArrayOutputStream

class NumbersFibonacciTest extends AnyFlatSpec with Matchers {

  behavior of "NumbersFibonacciLazy"
  val nfl = new NumbersFibonacciLazy
  // TODO apply this 2 tests for memo decision
  it should "lazy evaluated first 4 numbers" in {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) {
      nfl.getFirst(4) shouldBe List(0, 1, 1, 2)
    }
    out.close()
    out.toString shouldBe s"""(0 + 1)\n(1 + 1)\n"""
  }
  it should "lazy evaluated next 3 numbers" in {
    val out = new ByteArrayOutputStream()
    Console.withOut(out) {
      nfl.getFirst(7) shouldBe List(0, 1, 1, 2, 3, 5, 8)
    }
    out.close()
    out.toString shouldBe s"""(1 + 2)\n(2 + 3)\n(3 + 5)\n"""
  }
  it should behave like testBehaviour(nfl)

  behavior of "NumbersFibonacciRec"
  it should behave like testBehaviour(new NumbersFibonacciRec)

  behavior of "NumbersFibonacciMemo"
  it should behave like testBehaviour(new NumbersFibonacciMemo)

  private def testBehaviour(obj: NumbersFibonacci): Unit = {
    import obj._

    it should "-1" in {
      getNumber(-1) shouldBe None
    }
    it should "0" in {
      getNumber(0) shouldBe None
    }
    it should "1" in {
      getNumber(1) shouldBe Some(0)
    }
    it should "2" in {
      getNumber(2) shouldBe Some(1)
    }
    it should "3" in {
      getNumber(3) shouldBe Some(1)
    }
    it should "6" in {
      getNumber(6) shouldBe Some(5)
    }
    it should "90" in {
      getNumber(90) shouldBe Some(BigInt("1779979416004714189"))
    }
    it should "100" in {
      getNumber(100) shouldBe Some(BigInt("218922995834555169026"))
    }
  }

}
