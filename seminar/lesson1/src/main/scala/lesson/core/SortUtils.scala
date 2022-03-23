package lesson.core

object SortUtils {

  def harmfulSort(v: Int): Int = if (v > 1000) {
    v + 1
  } else {
    v
  }

}
