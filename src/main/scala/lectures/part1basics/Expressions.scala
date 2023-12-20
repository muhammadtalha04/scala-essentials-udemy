package lectures.part1basics

object Expressions extends App {
  // Arithmetic operators
  // + - * / & | ^ << >> >>>

  var a: Int = 1 + 2

  a += 1

  println(a)
  println(if (a==4) "RIGHT" else "WRONG")

  // Everything in Scala is an expression

  val codeBlock = {
    val x = 2
    val y = x+1

    if (y>2) "Y is greater" else "Y is smaller"
  }

  println(codeBlock)

  //1. Diff b/w "Hello World" and print("Hello World")
  // First is a String and second one is a Unit
  
  val someVal = {
    2 < 3
  }
  val someOtherVal = {
    if (someVal) 239 else 986
    42
  }

  println(someOtherVal)
}
