package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  // 1. Print n times string
  @tailrec
  def nTimesStr(str: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else nTimesStr(str, n-1, str + accumulator)
  }

  println( nTimesStr("Hello", 10, ""))

  // 2. Check if number is prime or not
  def isPrime(n: Int): Boolean = {
    @tailrec
    def hasFactor(divider: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (divider <= 1) true
      else hasFactor(divider - 1, (n % divider != 0) && isStillPrime)
    }

    hasFactor(n/2, true)
  }

  println(isPrime((2003)))
  println(isPrime((629)))

  // 3. Fibonacci number
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciHelper(i+1, last+nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }

  println(fibonacci(5))
}
