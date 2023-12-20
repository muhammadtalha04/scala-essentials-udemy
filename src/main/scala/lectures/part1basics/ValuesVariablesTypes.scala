package lectures.part1basics

object ValuesVariablesTypes extends App {
  //  VAL: Immutable
  println("Vals:")

  val aNumber: Int = 11
  val aString: String = "This is a string"
  val aBoolean = false
  val aChar = 'A'
  val anInt = aNumber
  val aShort: Short = 1212
  val aLong: Long = 123123123423L
  val aFloat: Float = 3.14f
  val aDouble: Double = 4.22

  println("INT: " + aNumber)
  println("STRING: " + aString)
  println("BOOLEAN: " + aBoolean)
  println("CHAR: " + aChar)
  println("INT: " + anInt)
  println("SHORT: " + aShort)
  println("LONG: " + aLong)
  println("FLOAT: " + aFloat)
  println("DOUBLE: " + aDouble)

  // VAR: Mutable
  println("Vars: ")

  var aVar: Int = 2

  aVar = 22

  println("INT: " + aVar)
}
