package com.lesson.two

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import scala.collection.immutable
import scala.util.Random

// ЗАДАНИЕ 4
// Получение элемента по индексу в разных коллекциях
// @OutputTimeUnit(TimeUnit.NANOSECONDS)
class GetElementBenchmarks {

  // Пример из лекции
  //    val rest = drop(n) // drop не хуже итерации по списку
  //    if (n < 0 || rest.isEmpty)
  //      throw new IndexOutOfBoundsException(n.toString)
  //    rest.head
  def test(scope: GetElementState): Int = ???

  // Библиотечные варианты
  def applySeq(scope: GetElementState) = scope.seq(scope.n)
  def applyList(scope: GetElementState) = scope.list(scope.n)
  def applyVector(scope: GetElementState) = scope.vector(scope.n)
  def applyArray(scope: GetElementState) = scope.array(scope.n)
  
}


class GetElementState {
  val n: Int = Random.between(1000, 10000)
  val seq: immutable.Seq[Int] = Seq.fill(10000)(Random.nextInt())
  val list: immutable.List[Int] = seq.toList
  val vector: immutable.Vector[Int] = seq.toVector
  val array: Array[Int] = seq.toArray
}
