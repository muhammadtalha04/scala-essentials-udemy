package lectures.part2oop

import scala.annotation.tailrec

object OOPBasics extends App {
  // Practice
  val person = new Person("Test", 26)

  println(person.age)
  println(person.gender)

  person.greet("Test1")
  person.greet()

  val author = new Writer("John", "Doe", 1812)
  val anotherAuthor = new Writer("John", "Doe", 1812)
  val novel = new Novel("New", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy((anotherAuthor)))

  val counter = new Counter

  counter.increment.print()
  counter.increment.increment.increment.print()
  counter.increment(10).print()
}

class Person(name: String, val age: Int) {
  // Body
  val gender = "M"

  println(gender)

  // Functions
  def greet(name: String): Unit = println(s"${this.name} says: Hi $name!")
  def greet(): Unit = println(s"Hi I am $name.")

  // Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("", 0)
}

class Writer(firstName:String, surname: String, val year: Int) {
  def fullName(): String = s"$firstName $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = yearOfRelease - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newReleaseDate: Int) = new Novel(name, newReleaseDate, author)
}

class Counter(val count: Int = 0) {
  def increment = new Counter(count + 1)
  def decrement = new Counter(count-1)

  def increment(num: Int): Counter = {
    if (num<=0) this
    else increment.increment(num-1)
  }

  def decrement(num: Int): Counter = {
    if (num <= 0) this
    else decrement.decrement(num - 1)
  }

  def print(): Unit = println(count)
}
