package com.lesson.two

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import scala.annotation.tailrec
import scala.util.Random

// ЗАДАНИЕ 2
// Переполнения стека в рекурсиях и хвостовая рекурсия
//@OutputTimeUnit(TimeUnit.MICROSECONDS)
class RecursionBenchmarks {

  // Пример из лекций
  def listAppendRecursive(scope: RecursionState) = {
    def appendTo(list: List[Int]): List[Int] =
      list match {
        case Nil => scope.element :: Nil
        case head :: tail => head :: appendTo(tail)
      }

    appendTo(scope.list)
  }

  // Предлагается исправить рекурсивный вариант, чтобы он не выпадал в StackOverflow.
  def listAppendTailRecursive(scope: RecursionState) = {
    @tailrec
    def appendTo(list: List[Int], acc: List[Int]): List[Int] = {
      ???
      appendTo(???, ???)
    }

    appendTo(scope.list, Nil)
  }

}


class RecursionState {
  val list: List[Int] = List.fill(10000)(Random.nextInt())
  val element: Int = 1
}
