package seminar

import seminar.ChessBoard._

/**
 * https://ru.wikipedia.org/wiki/История_шахмат, см. «Трактат о шахматах»
 * Вычислите количество зерен пшеницы на шахматной доске,
 * учитывая, что число на каждом квадрате удваивается.
 * На шахматной доске 64 квадрата (1ый квадрат имеет 1 зерно, 2ой квадрат имеет 2 зерна и т.д.).
 */
sealed trait ChessBoard {
  def totalCount: BigInt
  def squareCount(idx: Int): Option[BigInt]
}

object ChessBoard {
  val ChessBoardSize: Int = 64
}

class ChessBoardLazy extends ChessBoard {

  override lazy val totalCount: BigInt = grains.force.sum

  override def squareCount(idx: Int): Option[BigInt] =
    if (idx <= 0 || idx > ChessBoardSize) None
    else grains.take(idx).lastOption

  private[this] val grains: LazyList[BigInt] =
    LazyList.iterate(BigInt(1), ChessBoardSize)(_ * 2)

}

/**
 * Можно использовать побитовые сдвиги
 */
class ChessBoardBinary extends ChessBoard {

  override lazy val totalCount: BigInt = (BigInt(1) << ChessBoardSize) - 1

  override def squareCount(idx: Int): Option[BigInt] =
    if (idx <= 0 || idx > ChessBoardSize) None
    else Option(BigInt(1) << (idx - 1))

}
