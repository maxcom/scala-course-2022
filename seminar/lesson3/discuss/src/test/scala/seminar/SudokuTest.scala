package seminar

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

object Examples {

  val e3x3 = "010001120"

  // 78 known numbers, 3 unknown, 4 steps
  val game78 =
    "714962385" + "625834179" + "389157624" +
    "961285743" + "472613958" + "538749261" +
    "896421537" + "143576892" + "257090410"

  // 59 known numbers, 22 unknown, 42 steps
  val game59 =
    "651702090" + "030416257" + "742500006" +
    "000040562" + "460125038" + "523860000" +
    "285694371" + "004378625" + "376251849"

  // 31 known numbers, 50 unknown, 1004 steps
  val game31 =
    "014060300" + "620004009" + "080050600" +
    "060200003" + "070010050" + "500009060" +
    "006020030" + "100500092" + "007090410"

  // 29 known numbers, 52 unknown, 2571 steps
  val game29 =
    "100459000" + "803070900" + "000008000" +
    "508002600" + "900060007" + "007900105" +
    "000200000" + "006080204" + "000594003"

  // 25 known numbers, 56 unknown, 34734 steps
  val game25 =
    "000060300" + "000004009" + "080050600" +
    "060200003" + "070010050" + "500009060" +
    "006020030" + "100500092" + "007090000"

  // 21 known numbers, 60 unknown, 2803 steps
  val game21 =
    "100400000" + "800070900" + "000008000" +
    "508002600" + "900060007" + "007000105" +
    "000200000" + "006080000" + "000500003"

  // 20 known numbers, 61 unknown, 1918780 steps
  val game20 =
    "009008000" + "700000000" + "020100000" +
    "007000240" + "060010590" + "098000300" +
    "000800020" + "000000006" + "000200900"

  // 16 known numbers, 65 unknown, UNBELIEVABLE
  val game16 =
    "100000005" + "000030000" + "002040000" +
    "000000000" + "034000700" + "000206001" +
    "200005000" + "070000030" + "000001000"

}

//object SudokuTest extends App {
class SudokuTest extends AnyFlatSpec with Matchers {

  behavior of "Sudoku.solve"

  it should "game78" in {
    val solver = new Sudoku
    solver.solve(Examples.game78)
    solver.counter mustBe 4L
  }

  it should "game59" in {
    val solver = new Sudoku
    solver.solve(Examples.game59)
    solver.counter mustBe 42L
  }

  it should "game31" in {
    val solver = new Sudoku
    solver.solve(Examples.game31)
    solver.counter mustBe 1004L
  }

  it should "game29" in {
    val solver = new Sudoku
    solver.solve(Examples.game29)
    solver.counter mustBe 2571L
  }

  it should "game25" in {
    val solver = new Sudoku
    solver.solve(Examples.game25)
    solver.counter mustBe 34734L
  }

  it should "game21" in {
    val solver = new Sudoku
    solver.solve(Examples.game21)
    solver.counter mustBe 2803L
  }

  it should "game20" ignore {
    val solver = new Sudoku
    solver.solve(Examples.game20)
    solver.counter mustBe 1918780L
  }

  it should "game16" ignore {
    val solver = new Sudoku
    solver.solve(Examples.game16)
    1 mustBe 1
  }

}
