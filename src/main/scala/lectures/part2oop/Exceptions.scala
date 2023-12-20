package lectures.part2oop

object Exceptions extends App {
  // Throw exceptions
//  val nullValueExp = throw new NullPointerException

  // Catch exceptions
  def getInt(n: Int): Int = {
    if (n == 4) throw new RuntimeException("No int")
    else if (n == 22) throw new NullPointerException
    else 33
  }

  try {
    getInt(1)
    getInt(22)
    getInt(4)
    getInt(33)
  } catch {
    case e: RuntimeException => println("Runtime exception caught")
    case e1: NullPointerException => println("Null pointer exception caught")
  } finally {
    println("Handled")
  }

  // Custom exceptions
//  class MyException extends Exception
//  throw new MyException

  // Out of memory error
//  val arr = Array.ofDim[Int](Int.MaxValue)

  // Stack overflow error
//  def inf: Int = 1 + inf
//  val soErr = inf

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalcException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(a: Int, b: Int) = {
      val res = a + b

      if (a > 0 && b > 0 && res < 0) throw new OverflowException
      else if (a < 0 && b < 0 && res > 0) throw new UnderflowException
      else res
    }

    def subtract(a: Int, b: Int) = {
      val res = a - b

      if (a > 0 && b < 0 && res < 0) throw new OverflowException
      else if (a < 0 && b > 0 && res > 0) throw new UnderflowException
      else res
    }

    def multiply(a: Int, b: Int) = {
      val res = a * b

      if (a > 0 && b > 0 && res < 0) throw new OverflowException
      else if (a < 0 && b < 0 && res < 0) throw new OverflowException
      else if (a > 0 && b < 0 && res > 0) throw new UnderflowException
      else if (a < 0 && b > 0 && res > 0) throw new UnderflowException
      else res
    }

    def divide(a: Int, b: Int) = {
      if (b == 0) throw new MathCalcException
      else a / b
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))
//  println(PocketCalculator.divide(10,0))
}
