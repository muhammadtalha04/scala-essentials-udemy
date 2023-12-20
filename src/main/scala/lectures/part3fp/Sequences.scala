package lectures.part3fp

import scala.util.Random

object Sequences extends App {
  // Sequence
  val aSeq = Seq(6,4,2)

  println(aSeq)
  println(aSeq(2))
  println(aSeq.empty)
  println(aSeq.reverse)
  println((aSeq ++ Seq(3,5,1)).sorted)

  //Ranges
  val range: Seq[Int] = 1 to 10

  range.foreach(println)

  (1 to 3).foreach(x => println(s"a-${x}"))

  // List
  val aList = List(1,2,3,4)

  val prepend = 12 :: aList
  val prepend1 = 3 +: aList

  println(prepend)
  println(prepend1)

  val append = 12 +: aList :+ 22

  println(append)

  val hello5 = List.fill(5)("Hello")

  println(hello5)

  println(aList.mkString(" --> "))

  // Arrays
  val numbers = Array(1,2,3,4,5)

  println(numbers)
  println(numbers.mkString(", "))

  // Mutation
  numbers(2) = 33

  println(numbers.mkString(", "))

  // Implicit conversion from Array to Sequence
  val numberSeq: Seq[Int] = numbers

  println(numberSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1,2,3,4)

  println(vector)

  val noElems = Vector.empty
  val nums = noElems :+ 1 :+ 2 :+ 3 :+ 4
  val modif = nums updated (2,2)

  println(noElems)
  println(nums)
  println(modif)

  // vectors vs list
  val MAX_RUNS = 1000
  val MAX_CAPACITY = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to MAX_RUNS
    } yield {
      val startTime = System.nanoTime()
      collection.updated(r.nextInt(MAX_CAPACITY), r.nextInt())
      System.nanoTime() - startTime
    }

    (times.sum * 1.0) / MAX_RUNS
  }

  val numList = (1 to MAX_CAPACITY).toList
  val numVect = (1 to MAX_CAPACITY).toVector

  println("List: " + getWriteTime(numList))
  println("Vector: " + getWriteTime(numVect))
}
