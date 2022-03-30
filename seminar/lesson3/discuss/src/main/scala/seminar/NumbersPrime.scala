package seminar

import scala.annotation.tailrec

object NumbersPrime {

  /**
   * Получите список всех нечетных натуральных чисел
   */
  val odds: LazyList[BigInt] = LazyList.iterate(BigInt(1))(_ + 2)

  /**
   * https://ru.wikipedia.org/wiki/Решето_Эратосфена —
   * алгоритм нахождения всех простых чисел.
   * По мере прохождения списка нужные числа остаются, а ненужные исключаются.
   * Простое число делится только на самого себя и 1.
   * 1 не является простым числом.
   */
  val primes: LazyList[BigInt] =
    BigInt(2) #:: LazyList.iterate(BigInt(3))(_ + 2)
      .filter { n =>
        if (n <= 100) println(s"(try $n)")
        primes.takeWhile(_.pow(2) <= n).forall(n % _ != 0)
      }

  primes take 5 foreach println
  primes take 6 foreach println
  primes take 9 foreach println

  /**
   * Вычислите простые множители натурального числа.
   */
  def primeFactors(number: BigInt): List[BigInt] = {
    val One = BigInt(1)

    @tailrec
    def go(n: BigInt, acc: Vector[BigInt]): Vector[BigInt] = n match {
      case One => acc
      case _ =>
        val prime = primes.dropWhile(n % _ != 0).head
        go(n / prime, acc :+ prime)
    }

    if (number <= 0) List.empty
    else go(number, Vector.empty).toList
  }

}
