package lectures.part3fp

import scala.util.{Failure, Success, Try}

object ErrorHandling extends App {
  // create success and failure
  val aSuccess = Success(200)
  val aFailure = Failure(new RuntimeException("404 not found"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("Error!!")

  val potentialFailure = Try(unsafeMethod())

  println(potentialFailure.isSuccess).
  println(potentialFailure.isFailure)


}
