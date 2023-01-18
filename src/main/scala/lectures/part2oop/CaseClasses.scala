package lectures.part2oop

object CaseClasses extends App {
  case class Person(name: String, age: Int)

  // 1. Params are fields
  println("1. Params are fields:")

  val john = Person("John", 23)
  println(s"Name: ${john.name}, Age: ${john.age}")

  // 2. toString
  println("\n2. toString:")

  println(john.toString)
  println(john)
  println(john.toString.equals(john))

  // 3. Compare objects
  println("\n3. Compare objects:")

  val john1 = Person("John", 23)

  println(john == john1)

  // 4. Copy object
  println("\n4. Copy object:")

  val john2 = john.copy(age = 33)

  println(john2)

  // 5. Companion objects
  println("\n5. Companion objects:")

  val firstPerson = Person
  val secondPerson = Person("Jim", 43)

  println("Person1: " + firstPerson.toString)
  println("Person2: " + secondPerson.toString)

  // 6. Serializable

  // 7. Case objects
  println("\n7. Case objects:")

  case object Country {
    val name: String = "PK"
  }

  println(Country.name)
}
