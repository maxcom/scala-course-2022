package com.lesson.two

import org.openjdk.jmh.annotations.{BenchmarkMode, Fork, Measurement, Mode, OutputTimeUnit, Warmup}

import java.util.concurrent.TimeUnit
import scala.util.Random

// ЗАДАНИЕ 1
// Сравниваем добавление элементов в начало и конец списка.
class AddElementBenchmarks {

  //Пример из лекций: список раскручивается в стек, стек собирается в новый список
  //     def append(list: List[Int], element: Int): List[Int] = {
  //      list match {
  //        case Nil =>
  //          v :: Nil
  //        case head :: tail =>
  //          head :: append(tail, element)
  //      }
  //    }
  def listAppendRecursive = ???

  //Пример из лекций: та же логика через reverse
  //    (1 +: list).reverse
  def listAppendReverse = ???

  //Библиотечный вариант:
  //    list :+ element
  def listAppend = ???

  //Сравниваем с добавлением в начало списка:
  //    element +: list
  def listPrepend = ???

}


class AddElementState {
  val list: List[Int] = List.fill(10000)(Random.nextInt())
  val element: Int = 1
}
