package lectures.part2oop

object Generics extends App {
  // Generic Class
  class MyList[A] {
  }

  class Map[key, value] 

  val intList = new MyList[Int]
  val strList = new MyList[String]

  // Generic Methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyIntList = MyList.empty[Int]

  // Variance
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // Invariance
  class InvariantList[A]
  val invariantAnimalsList: InvariantList[Animal] = new InvariantList[Animal]
  //Contravariance
  class ContravarianceList[-A]
  val trainer: ContravarianceList[Cat] = new ContravarianceList[Animal]

  // Bounded Types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)
}
