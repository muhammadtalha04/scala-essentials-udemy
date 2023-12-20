package lectures.part2oop

object Objects extends App {
  // Singleton instance
  object Person {
    // static level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: String, father: String): Person = new Person("Bobbie")
  }
  class Person(val name: String) {}

  println(Person.N_EYES)
  println(Person.canFly)

  val mary = new Person("Mary")
  val john = new Person("John")

  println(mary == john)

  val person1 = Person
  val person2 = Person

  println(person1 == person2)
}
