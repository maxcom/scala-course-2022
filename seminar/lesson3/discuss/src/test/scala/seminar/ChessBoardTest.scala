package seminar

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ChessBoardTest extends AnyFlatSpec with Matchers {

  behavior of "ChessBoardGrainsLazy"
  it should behave like testBehaviour(new ChessBoardLazy)

  behavior of "ChessBoardGrainsBinary"
  it should behave like testBehaviour(new ChessBoardBinary)


  private def testBehaviour(obj: ChessBoard): Unit = {
    import obj._

    it should "1" in {
      squareCount(1) shouldBe Some(1)
    }
    it should "2" in {
      squareCount(2) shouldBe Some(2)
    }
    it should "3" in {
      squareCount(3) shouldBe Some(4)
    }
    it should "4" in {
      squareCount(4) shouldBe Some(8)
    }
    it should "16" in {
      squareCount(16) shouldBe Some(32768)
    }
    it should "32" in {
      squareCount(32) shouldBe Some(BigInt("2147483648"))
    }
    it should "64" in {
      squareCount(64) shouldBe Some(BigInt("9223372036854775808"))
    }
    it should "squareCount 0 raises an exception" in {
      squareCount(0) shouldBe None
    }
    it should "negative squareCount raises an exception" in {
      squareCount(-1) shouldBe None
    }
    it should "squareCount greater than 64 raises an exception" in {
      squareCount(65) shouldBe None
    }
    it should "returns the totalCount number of grains on the board" in {
      totalCount shouldBe BigInt("18446744073709551615")
    }
  }

}
