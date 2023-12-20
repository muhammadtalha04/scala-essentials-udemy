package lectures.part2oop

import scala.annotation.targetName

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def print: String
  override def toString: String = s"[$print]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  @targetName("++")
  def ++[B >: A](list: MyList[B]): MyList[B]

  def foreach(fn: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)
  def print: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  @targetName("++")
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def foreach(fn: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else Empty
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = new Cons(n, this)
  def print: String =
    if (t.isEmpty) "" + h
    else s"$h, ${t.print}"

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  @targetName("++")
  def ++[B >: A](list: MyList[B]): MyList[B] =
    new Cons(h, t ++ list)

  def foreach(fn: A => Unit): Unit = {
    fn(h)
    t.foreach(fn)
  }
  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(n: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(n, Empty)
      else if (compare(n, sortedList.head) < 0) new Cons(n, sortedList)
      else new Cons(sortedList.head, insert(n, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

object ListTest extends App {
  //  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  //  println(list.tail.tail.head)
  //  println(list.toString)
  val listOfInt: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  val listOfInt1: MyList[Int] = new Cons(5, new Cons(6, new Cons(7, new Cons(8, Empty))))
  val listOfStr: MyList[String] = new Cons("A", new Cons("B", new Cons("C", new Cons("D", Empty))))

  println(listOfInt.toString)
  println(listOfStr.toString)

  println("\nMap:")
  println(listOfInt.map(elem => s"${elem}x2=${elem*2}"))

  println("\nFilter:")
  println(listOfInt.filter(_ % 2 == 0))

  println("\nConcatenation:")
  println((listOfInt ++ listOfInt1).toString)

  println("\nFlatmap:")
  println(listOfInt.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))))

  println("\nSort:")
  println(listOfInt.sort((x, y) => y-x))

  println("\nZip With:")
  println(listOfInt1.zipWith[String, String](listOfStr, _ + "-" + _))

  println("\nFold:")
  println(listOfInt.fold(0)(_ + _))
}