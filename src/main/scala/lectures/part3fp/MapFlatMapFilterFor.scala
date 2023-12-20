package lectures.part3fp

import lectures.part2oop.{Cons, Empty, MyList}

object MapFlatMapFilterFor extends App {
  val list = List(1,2,3,4,5)

  println(list)
  println(list.head)
  println(list.tail)

  // Map
  println(list.map(_ + 2))
  println(list.map(_ + ". A"))

  // Filter
  println(list.filter(_ % 2 == 0))

  // Flatmap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // Exercise
  // Print all possible combinations List("a1", "a2", "a3", ..., "d4")
  val numbers = List(1,2,3,4)
  val chars = List('a','b', 'c','d')
  val colors = List("black", "white")

  val combinations = chars.flatMap(c => numbers.filter(_%2==0).flatMap(n => colors.map(col => "" + c + n + "-" + col)))
  println(combinations)

  // Foreach
  list.foreach(println)

  // For combinations
  val forCombinations = for {
    c <- chars
    n <- numbers if n%2==0
    col <- colors
  } yield ("" + c + n + "-" + col)

  println(forCombinations)

  // Syntax overload
  list.map { x =>
    x*2
  }

  // Exercise

  //1. Check if mylist supports for comprehensions
  val listOfInt: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val listOfStr: MyList[String] = new Cons("a", new Cons("b", new Cons("c", new Cons("d", Empty))))

  val forComp = for {
    s <- listOfStr
    n <- listOfInt
  } yield ("" + s + n)

  println(forComp)


}
