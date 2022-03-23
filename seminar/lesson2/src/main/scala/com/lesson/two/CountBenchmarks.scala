package com.lesson.two

import org.openjdk.jmh.annotations._

import java.util.concurrent.TimeUnit
import scala.util.Random

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.AverageTime))
@Fork(value = 1)
@Warmup(iterations = 5)
@Measurement(iterations = 1)
class CountBenchmarks {

  // Плохая реализация через filter
  // Не эффективно, создает временный список т.к. операции над коллекциями не меняют тип
  @Benchmark
  def badVersion(scope: CountState) =
    scope.list.filter(scope.checkFunc).length

  // Через foldLeft
  @Benchmark
  def betterVersion(scope: CountState) =
    scope.list.foldLeft(0) { (acc, v) =>
      if (scope.checkFunc(v)) acc + 1
      else acc
    }

  @Benchmark
  def libraryVersion(scope: CountState) =
    scope.list.count(scope.checkFunc)
  
}


@State(Scope.Benchmark)
class CountState {
  val list: List[Int] = List.fill(10000)(Random.nextInt())
  val checkFunc: Int => Boolean = _ > 50
}
