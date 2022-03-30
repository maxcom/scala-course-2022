package seminar

import scala.util.Random.shuffle

/**
 * При создании терминатора генерируется случайное имя в формате RX837 или BC811.
 * Существует 26^2 * 10^3 = 676 000 возможных имен.
 *
 * Мы должны уметь стирать имя терминатора, и создавать новое случайное имя.
 *
 * Мы должны гарантировать, что каждый терминатор имеет уникальное имя,
 * что ни одно из имен не повторяется.
 * Для этого воспользуемся встроенным кэшем LazyList.
 */
class Terminator {
  def name: String = _name
  def reset(): Unit = _name = Terminator.generateName
  private[this] var _name: String = Terminator.generateName
}

object Terminator {
  def generateName: String =
    if (names.isEmpty) throw new RuntimeException("all names are used")
    else {
      val head #:: tail = names
      names = tail
      head
    }

  private[this] val letters: Seq[Char] = 'A' to 'Z'
  private[this] val digits: Seq[Char] = '0' to '9'
  private[this] var names: LazyList[String] = for {
    l1 <- shuffle(letters).to(LazyList)
    l2 <- shuffle(letters).to(LazyList)
    d1 <- shuffle(digits).to(LazyList)
    d2 <- shuffle(digits).to(LazyList)
    d3 <- shuffle(digits).to(LazyList)
  } yield s"$l1$l2$d1$d2$d3"
}
