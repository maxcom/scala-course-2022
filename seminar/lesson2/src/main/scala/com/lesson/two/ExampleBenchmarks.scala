package com.lesson.two

import org.openjdk.jmh.annotations._
import java.util.concurrent.TimeUnit
import scala.util.Random

// jmh:run ExampleBenchmarks -f 1 -i 1 -wi 5
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.AverageTime))
@Fork(value = 1)
@Warmup(iterations = 5)
@Measurement(iterations = 1)
class ExampleBenchmarks {

  // list :+ element
  @Benchmark
  def listAppend(scope: ExampleState) = scope.list :+ scope.element

  // element +: list
  @Benchmark
  def listPrepend(scope: ExampleState) = scope.element +: scope.list
  
}


@State(Scope.Benchmark)
class ExampleState {
  val list: List[Int] = List.fill(10000)(Random.nextInt())
  val element: Int = 1
}
