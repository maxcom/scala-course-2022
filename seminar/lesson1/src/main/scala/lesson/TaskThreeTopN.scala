package lesson

import core.InputData

import scala.annotation.tailrec
import scala.collection.mutable


object TaskThreeTopN {

  @tailrec
  private def merge(l: Vector[Int], r: Vector[Int], acc: Vector[Int] = Vector.empty): Vector[Int] = {
    (l, r) match {
      case (Vector(), _) => acc ++ r
      case (_, Vector()) => acc ++ l
      case (lH +: lT, rH +: rT) =>
        if (lH < rH) merge(lT, r, acc :+ lH)
        else merge(l, rT, acc :+ rH)
    }
  }

  private def mergeSort(a: Vector[Int]): Vector[Int] = {
    if (a.length < 2) a
    else {
      val (l, r) = a.splitAt(a.length / 2)
      merge(mergeSort(l), mergeSort(r))
    }
  }

  def topN(input: InputData): Vector[Int] = {
    val temp: mutable.PriorityQueue[Int] = mutable.PriorityQueue.empty[Int]
    for (i <- input.vector.indices) {
      if (i < input.n) {
        temp.enqueue(input.vector(i))
      } else if (input.n > 0) {
        if (input.vector(i) < temp.head) {
          temp.dequeue()
          temp.enqueue(input.vector(i))
        }
      }
    }
    mergeSort(temp.toVector).distinct
  }
}



