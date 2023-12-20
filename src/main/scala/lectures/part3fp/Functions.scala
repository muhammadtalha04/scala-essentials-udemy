package lectures.part3fp

object Functions extends App {
  // Practice
  val doubler = new CustomFunction[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }

  val toInt = new Function1[String, Int] {
    override def apply(elem: String): Int = elem.toInt
  }

  println("4x2x2: " + doubler(toInt("4")) * 2)

  val customAdder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = (a + (a-1)) + (b + (b+1))
  }

  println("(3 + 2) + (7 + 8): " + customAdder(3, 7))

  // Exercise
  // 1. Concat 2 strings
  val concat: (String, String) => String = new Function2[String, String, String] {
    override def apply(str1: String, str2: String): String = str1+str2
  }

  println(concat("Hello ", "World"))

  // 2. transform the MyPredicate and MyTransformer into function types

  // 3. function to take and int and return a function that takes and int and return an int
  val specialFunc: (Int) => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(elem: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(elem1: Int): Int = elem+elem1
    }
  }

  val adder3 = specialFunc(3)

  println(adder3(4))
  println(specialFunc(5)(4))  // Currying
}

trait CustomFunction[A, B] {
  def apply(elem: A): B
}