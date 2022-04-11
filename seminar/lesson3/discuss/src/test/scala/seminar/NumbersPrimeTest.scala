package seminar

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

// https://en.wikipedia.org/wiki/List_of_prime_numbers
class NumbersPrimeTest extends AnyFunSuite with Matchers {

  test("first 10 prime numbers") {
    NumbersPrime.primes.take(10).toList shouldBe List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
  }

  test("prime number #1000") {
    NumbersPrime.primes.take(1000).force.last shouldBe 7919
  }

  test("no primeFactors for negative number") {
    NumbersPrime.primeFactors(-5) should be(List())
  }

  test("no primeFactors for zero") {
    NumbersPrime.primeFactors(0) should be(List())
  }

  test("no primeFactors for 1") {
    NumbersPrime.primeFactors(1) should be(List())
  }

  test("prime number") {
    NumbersPrime.primeFactors(2) should be(List(2))
  }

  test("another prime number") {
    NumbersPrime.primeFactors(29) should be(List(29))
  }

  test("squareCount of a prime") {
    NumbersPrime.primeFactors(9) should be(List(3, 3))
  }

  test("cube of a prime") {
    NumbersPrime.primeFactors(8) should be(List(2, 2, 2))
  }

  test("product of primes and non-primes") {
    NumbersPrime.primeFactors(12) should be(List(2, 2, 3))
  }

  test("product of primes") {
    NumbersPrime.primeFactors(901255) should be(List(5, 17, 23, 461))
  }

  test("primeFactors include a large prime") {
    NumbersPrime.primeFactors(93819012551L) should be(List(11, 9539, 894119))
  }

}
