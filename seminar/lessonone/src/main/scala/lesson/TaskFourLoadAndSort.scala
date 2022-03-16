package lesson

import core.DBService

class TaskFourLoadAndSort(dbService: DBService) {

  def sortSomethingPlz: Vector[Int] = dbService.giveMeVector.sorted

}
