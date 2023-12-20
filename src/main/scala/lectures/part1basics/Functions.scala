package lectures.part1basics

object Functions extends App {
  def stringPlusInt(s: String, n: Int): String = {
    s + ": " + n
  }

  println(stringPlusInt("Int", 3));

  def sideEffectsFunction(str: String): Unit = println("Hello " + str)

  sideEffectsFunction("World")

  def parentFunc(n: Int): Int = {
    def childFunc(a: Int, b: Int): Int = a + b

    childFunc(n, n+1)
  }

  println(parentFunc(33))

  // Exercise:
  println("\nExercise:")
  // 1. Greeting function
  def greetingFn(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }

  println("1. Greetings: " + greetingFn("Test", 26))

  // 2. Factorial function
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n-1)
  }

  println(stringPlusInt("2. Factorial", factorial(4)))

  // 3. Fibonacci function
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  println(stringPlusInt("3. Fibonacci", fibonacci(10)))

  // 4. Prime or not function
  def isPrime(n: Int): Boolean = {
    def hasFactor(divider: Int): Boolean = {
      if (divider <= 1) true
      else (n%divider != 0) && hasFactor(divider - 1)
    }

    hasFactor(n-1)
  }

  println("4. Is 11 Prime: " + isPrime(3))
}
