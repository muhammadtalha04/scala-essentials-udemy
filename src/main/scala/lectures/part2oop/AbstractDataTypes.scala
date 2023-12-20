package lectures.part2oop

object AbstractDataTypes extends App {
  // Abstract classes
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "Croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal:Animal): Unit = println(s"I'm a $creatureType and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat
  croc.eat(dog)
}
