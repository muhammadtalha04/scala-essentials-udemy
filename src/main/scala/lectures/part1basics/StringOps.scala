package lectures.part1basics

object StringOps extends App {
  //Practice
  val str: String = "  Hello World!  "

  println(str.trim)
  println(str.charAt(4))
  println(str.substring(0, 8))
  println(str.length)
  println(str.split(" ").toList)

  println(str.toLowerCase)
  println(str.toUpperCase)
  println(str.replace(" ", ":"))

  val numStr = "12"

  println(numStr.toLong)

  // f-interpolator
  val fl = 1.2f

  var str1 = f"Two decimal places: $fl%2.2f"

  println(str1)

  val lines = "Line1\nLine2"

  println(raw"$lines")

}
