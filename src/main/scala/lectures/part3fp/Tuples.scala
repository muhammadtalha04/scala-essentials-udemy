package lectures.part3fp

import scala.annotation.tailrec

object Tuples extends App {
  val aTuple = (2, "hello", "world")

  println(aTuple)
  println(aTuple._1)
  println(aTuple.copy(_2 = "bye"))

  // map
  val phonebook = Map(("Jim", 555), "JIM" -> 900 , "Daniel" -> 789).withDefaultValue(-1)

  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 123
  val newPhonebook = phonebook + newPairing

  println(newPhonebook)

  // functions on maps
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filter keys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toList)

  // map values
  println(phonebook.view.mapValues(num => "0245-" + num).toList)

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  // Exercise

  /* 1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900?
  * !!! careful with mapping keys
  * */

  /*
  * 2. Overly simplified social network based on maps
  *   Person = String
  *   - add a person to network
  *   - remove
  *   - friend (mutual)
  *   - unfriend
  *
  *   - number of friends of a person
  *   - person with most friends
  *   - how many people have no friends
  *   - if there is a social connection between two people (direct or not)
  * */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA = network(personA)
    val friendsB = network(personB)

    network + (personA -> (friendsA + personB)) + (personB -> (friendsB + personA))
  }

  def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
    val friendsA = network(personA)
    val friendsB = network(personB)

    network + (personA -> (friendsA - personB)) + (personB -> (friendsB - personA))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

    val unfriended = removeAux(network(person), network)

    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  var network: Map[String, Set[String]] = add(add(empty, "Bob"), "Mary")

  println(network)

  network = friend(network, "Bob", "Mary")
  println(network)

  network = unfriend(network, "Bob", "Mary")
  println(network)

  network = friend(network, "Bob", "Mary")
  network = remove(network, "Bob")
  println(network)

  println()

  var people = add(add(add(add(empty, "Bob"), "Mary"), "Jim"), "Jack")
  people = friend(people, "Bob", "Jim")
  people = friend(people, "Bob", "Mary")

  println(people)

  def nFriends(network: Map[String, Set[String]], person: String): Int = {
    if (!network.contains(person)) 0
    else network(person).size
  }

  println("No of friends of Bob: " + nFriends(people, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(_._2.size)._1

  println("Person with most friends: " + mostFriends(people))

  def peopleWithNoFriends(network:  Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  println(peopleWithNoFriends(people))

  def socialConnection(network: Map[String, Set[String]], personA: String, personB: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      println("Debugging rec start")
      println("T:" + target)
      println("D:" + discoveredPeople.toList)
      println("C:" + consideredPeople.toList)
      println("Debugging rec stop\n")

      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head

        if (person == target) true
        else if(consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    println("\nConnection for " + personA + " & " + personB)
    bfs(target = personB, consideredPeople = Set(), discoveredPeople = network(personA) + personA)
  }

  println("Social connection b/w Mary and Jim: " + socialConnection(people, "Mary", "Jim"))
  println("Social connection b/w Mary and Jack: " + socialConnection(people, "Mary", "Jack"))
}
