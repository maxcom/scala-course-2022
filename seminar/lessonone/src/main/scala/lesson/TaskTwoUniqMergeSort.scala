package lesson

import lesson.core.Utils.ALL
import scala.annotation.tailrec

object TaskTwoUniqMergeSort {
  @tailrec
  private def merge(l: Vector[Int], r: Vector[Int], acc: Vector[Int] = Vector.empty): Vector[Int] = {
    (l, r) match {
      case (Vector(), _) => acc ++ r
      case (_, Vector()) => acc ++ l
      case (lH +: lT, rH +: rT) =>
        if (lH < rH) merge(lT, r, acc :+ lH)
        else if (lH > rH) merge(l, rT, acc :+ rH)
        else merge(lT, rT, acc :+ lH)
    }
  }

  def sort(input: Vector[Int]): Vector[Int] = mergeSort(input).take(ALL)

  private def mergeSort(input: Vector[Int]): Vector[Int] = {
    if (input.length < 2) input
    else {
      val (l, r) = input.splitAt(input.length / 2)
      merge(mergeSort(l), mergeSort(r))
    }
  }

}



