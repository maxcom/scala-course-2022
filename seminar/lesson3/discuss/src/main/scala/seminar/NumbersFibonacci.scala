package seminar

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
 * https://www.scala-lang.org/api/current/scala/collection/immutable/LazyList.html
 */
sealed trait NumbersFibonacci {
  def getFirst(count: Int): Seq[BigInt] = if (count > 0) crop(count) else Seq.empty

  def getNumber(n: Int): Option[BigInt] = Option.when(n > 0)(crop(n).last)

  // TODO add tests
  protected def crop(n: Int): Seq[BigInt]
}

class NumbersFibonacciLazy extends NumbersFibonacci {
  override def crop(n: Int): Seq[BigInt] = fibs.take(n)

  //private[this] val fibs: LazyList[BigInt] = BigInt(0) #:: fibs.scan(BigInt(1))(_ + _)
  private[this] val fibs: LazyList[BigInt] =
    BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { case (l, r) =>
      if (r <= 55) println(s"($l + $r)")
      l + r
    }
}

class NumbersFibonacciRec extends NumbersFibonacci {
  override def crop(n: Int): Seq[BigInt] = fibs(n)

  @tailrec
  private[this] def fibs(n: Int,
                         i: Int = 2,
                         prev: BigInt = 0,
                         cur: BigInt = 1,
                         acc: Vector[BigInt] = Vector(0, 1)): Vector[BigInt] = n match {
    case 1 => Vector(prev)
    case _ if n == i => acc
    case _ => fibs(n, i + 1, cur, prev + cur, {
      if (n <= 10) print(s"($prev + $cur)")
      acc :+ (prev + cur)
    })
  }
}

class NumbersFibonacciMemo extends NumbersFibonacci {
  override def getNumber(n: Int): Option[BigInt] = Option.when(n > 0)(fibM(n))

  // TODO implement, update tests
  override def crop(n: Int): Seq[BigInt] = ???

  private[this] val fibM: Int => BigInt = memoize {
    case 1 => 0
    case 2 => 1
    case n =>
      val prev = fibM(n - 2)
      val cur = fibM(n - 1)
      if (n <= 10) print(s"($prev + $cur)")
      prev + cur
  }

  private[this] def memoize[K, V](f: K => V): K => V = {
    val cache = mutable.Map.empty[K, V]
    k => cache.getOrElseUpdate(k, f(k))
  }
}
