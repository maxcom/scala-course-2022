package seminar

/**
 * https://kpacha.github.io/2014/10/26/solving-sudoku-puzzles-with-scala-streams.html
 * Разобраться в программе, решающей Судоку, используя LazyList
 */
class Sudoku {

  var counter: Long = 0L
  val EmptyValue = '0' // the char representing the empty cells
  val MaxValue = 9 // the number of columns and rows

  val allValues = "123456789".toList // the list of all possible values of a cell
  val indexes = (0 to 8).toList // the list of column and row indexes
  val boxCoordinates = (0 to 2).toList

  def getX(pos: Int): Int = pos % MaxValue

  def getY(pos: Int): Int = pos / MaxValue

  def box(pos: Int): List[Int] = {
    def base(p: Int): Int = (p / 3) * 3

    val x0 = base(getX(pos))
    val y0 = base(getY(pos))
    val ys = (y0 until y0 + 3).toList
    (x0 until x0 + 3).toList.flatMap(x => ys.map(x + _ * 9))
  }

  val boxes = boxCoordinates flatMap (x => boxCoordinates map (x * 3 + _ * 3 * 9)) map box

  class Board(val game: String) {
    { // info block, unnecessary
      if (counter == 0) {
        val known = game.replaceAll("0", "").length
        println(s"the solver starts with $known known numbers and ${game.length - known} unknown")
        println(this)
      }
      counter += 1
      if (counter % 50000 == 0) println((game, counter))
    }

    val empty: Int = game indexOf EmptyValue
    val isDone: Boolean = empty == -1

    def row(y: Int): List[Char] = indexes map (col => game(y * MaxValue + col))

    def col(x: Int): List[Char] = indexes map (row => game(x + row * MaxValue))

    def box(pos: Int): List[Char] = (boxes filter (_ contains pos)).head map game

    def toAvoid(pos: Int): List[Char] = (col(getX(pos)) ++ row(getY(pos)) ++ box(pos)).distinct

    def candidates(pos: Int): List[Char] = allValues diff toAvoid(pos)

    // новый Board, в котором 1 из пустых ячеек исправили
    def updated(pos: Int)(value: Char): Board = new Board(game updated(pos, value))

    // список досок, таких что в emptyPosition указан 1 из candidates
    def next: LazyList[Board] =
      if (isDone) LazyList.empty
      else candidates(empty).to(LazyList) map updated(empty)

    override def toString: String = "\n" + (game grouped MaxValue mkString "\n")
  }

  val steps = (game: String) => {
    def loop(p: Board): LazyList[Board] = p #:: p.next.flatMap(loop)

    loop(new Board(game))
  }

  def solve(game: String): Board = {
    val res = steps(game).filter(_.isDone).head
    println(res)
    println(s"\nsteps: $counter")
    res
  }

}
