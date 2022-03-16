package lesson

import lesson.core.SortUtils

import scala.annotation.tailrec
import scala.util.Random

object TaskOneMergeSort {


  @tailrec
  private def merge(l: Vector[Int], r: Vector[Int], acc: Vector[Int] = Vector.empty): Vector[Int] = {
    (l, r) match {
      case (Vector(), _) => acc ++ r
      case (_, Vector()) => acc ++ l
      case (lH +: lT, rH +: rT) =>
        if (lH < rH) {
          merge(lT, r, acc :+ lH)
        } else {
          merge(l, rT, acc :+ rH)
        }
    }
  }

  def sort(input: Vector[Int]): Vector[Int] = mergeSort(input)

  private def mergeSort(input: Vector[Int]): Vector[Int] = {
    if (input.length < 2) {
      input.map(SortUtils.harmfulSort)
    } else {
      val (left, right) = input.splitAt(input.length / 2)
      merge(mergeSort(left), mergeSort(right))
    }
  }

}



