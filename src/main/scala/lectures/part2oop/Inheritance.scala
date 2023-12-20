package lectures.part2oop

object Inheritance extends App {
  // Single class inheritance
  class Animal {
    val creatureType = "Wild"
    def eat = println("Eating..")
  }
  class Cat extends Animal {
    def crunch = {
      eat
      println("Cat: crunch crunch")
    }
  }

  val cat =  new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
    def this() = this("John", 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name) {}

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "Domestic"
    override def eat = {
      super.eat
      println("Dog: crunch crunch")
    }
  }

  val dog = new Dog("Domestic")
  dog.eat
  println(dog.creatureType)

  // Polymorphism
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding vs overloading

  // super

  /*
  * prevent overriding by using final keyword before
  * 1. method name
  * 2. class name
  * also by using seal keyword before class name
  * */


}
