package com.lesson.two

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import scala.annotation.tailrec
import scala.util.Random

// ЗАДАНИЕ 3
// Собираем список из N элементов.
// Сравниваем добавление по одному в начало, в конец, конструктор списка, конструктор Range и RichInt.
// @OutputTimeUnit(TimeUnit.NANOSECONDS)
class CreateListBenchmarks {


  //    var i = 0
  //    var list: List[Int] = Nil
  //    while(i < scope.n) {
  //      list = list :+ i
  //      i += 1
  //    }
  def createListAppendig(scope: CreateListState) = ???


  //    @tailrec
  //    def addNext(acc: List[Int], nextElem: Int, leftCount: Int): List[Int] =
  //      if (leftCount == 0) acc
  //      else addNext(acc :+ nextElem, nextElem + 1, leftCount - 1)
  //
  //    addNext(Nil, 0, scope.n)
  def createListAppendigFunctional(scope: CreateListState) = ???


  //    var i = 0
  //    var list: List[Int] = Nil
  //    while(i < scope.n) {
  //      list = (scope.n - i - 1) +: list
  //      i += 1
  //    }
  def createListPrepending(scope: CreateListState) = ???


  //    @tailrec
  //    def addNext(acc: List[Int], nextElem: Int, leftCount: Int): List[Int] =
  //      if (leftCount == 0) acc
  //      else addNext(nextElem +: acc, nextElem - 1, leftCount - 1)
  //
  //    addNext(Nil, scope.n - 1, scope.n)
  def createListPrependingFunctional(scope: CreateListState) = ???


  //    List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  def createList(scope: CreateListState) = ???


  //    Range(0, scope.n).toList
  def createListFromRange(scope: CreateListState) = ???


  //    (0 until scope.n).toList
  def createListRichInt(scope: CreateListState) = ???


}


class CreateListState {
  val n: Int = 10
}
