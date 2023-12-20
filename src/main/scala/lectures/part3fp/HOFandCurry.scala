package lectures.part3fp

object HOFnCurry extends App {
  // Practice
  def nTimes(fn: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(fn, n-1, fn(x))
  }

  println(nTimes(_+1, 10, 1))

  def nTimesCurr(fn: Int=>Int, n: Int): (Int=>Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesCurr(fn, n-1)(fn(x))

  val plus10 = nTimesCurr(_+1, 10)

  println(plus10(1))

  // Exercise

  // toCurry and fromCurry functions
  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)
  def fromCurry(f: (Int => Int => Int)): ((Int, Int) => Int) =
    (x, y) => f(x)(y)

  // compose and andThen functions
  def compose[A, B, C](f: A => B, g: C => A): C => B =
    x => f(g(x))
  def andThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder: (Int => Int => Int) = toCurry(_ + _)
  val add10 = superAdder(10)

  println(add10(33))

  val simpleAdder = fromCurry(superAdder)

  println(simpleAdder(4, 13))

  def add2: Int => Int = _ + 2
  def times3: Int => Int = _ * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println("Composed: " + composed(4))
  println("Ordered: " + ordered(4))
}
