package lectures.part1basics

object CallByValueName extends App {
  // Practice
  def callByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }
  def callByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(10, infinite())
}
