package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  // Practice & Exercise
  class Person(val name: String, favoriteMovie: String, val age: Int) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nick: String): Person = new Person(s"${this.name} (${nick})", favoriteMovie, age)

    def unary_+ : Person = new Person(name, favoriteMovie, age+1)

    def learns(learn: String) = s"$name learns $learn"
    def learnsScala = learns("Scala")

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(numOfTimes: Int): String = s"${this.name} watched $favoriteMovie $numOfTimes times"
  }

  val mary = new Person("Mary", "Inception", 20)
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club", 23)
  println(mary + tom)
  println(mary.+(tom))

  println((mary + "the rockstar")())

  println(mary learnsScala)

  println(mary.age)
  println((+mary).age)

  println(mary.apply(2))
}
