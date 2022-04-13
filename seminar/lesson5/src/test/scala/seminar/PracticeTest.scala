package seminar

import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.must.Matchers
import seminar.Practice._

class PracticeTest extends AsyncFlatSpec with Matchers {

  it should "count file lines" in {
    countFileLinesF.map(_ mustBe 99)
  }

}
