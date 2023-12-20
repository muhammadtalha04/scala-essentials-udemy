package lectures.part3fp

object AnonFunctions extends App {
  // anonymous function [lambda]
  val doubler = (a: Int) => a*2

  // multiple params
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a+b

  // no params
  val nothing: () => Int = () => 11

  println(nothing)
  println(nothing())

  // curly braces with lambda
  val toInt = {
    (str: String) => str.toInt
  }

  println(toInt("12"))

  // MOAR syntactic sugar
  val incrementer: Int => Int = _ + 1 // equal to x => x+1
  val newAdder: (Int, Int) => Int = _ + _ // equal to (a,b) => a+b

  println(incrementer(3))
  println(newAdder(3,2))

  // Exercise

  // 1. replace all Function calls in MyList with lambda

  // 2. rewrite the special adder function as an anon function
  val specialAdder = (a: Int) => (b: Int) => a + b

  println(specialAdder(3)(4))
}
