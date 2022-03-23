package com.lesson.two

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import scala.util.Random


// ЗАДАНИЕ 5
// Реализация функции count
// Сравниваем плохой и хороший варианты из лекции и библиотечный вариант.
// Реализуем вариант с рекурсивным обходов
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
class CountBenchmarks {

  // Плохая реализация через filter
  // Не эффективно, создает временный список т.к. операции над коллекциями не меняют тип
  def badVersion(scope: CountState) =
    scope.list.filter(scope.checkFunc).length

  // Через foldLeft
  def betterVersion(scope: CountState) = ???

  // Сравнить с библиотечным count
  def libraryVersion(scope: CountState) = ???


  // ЗАДАНИЕ СО ЗВЁЗДОЧКОЙ: еще можно реализовать рекурсивным обходом списка
  def recVersion(scope: CountState) = ???
  
}


class CountState {
  val list: List[Int] = List.fill(10000)(Random.nextInt())
  val checkFunc: Int => Boolean = _ > 50
}
