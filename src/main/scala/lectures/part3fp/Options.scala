package lectures.part3fp

import java.util.Random

object Options extends App {
  val firstOpt: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println("First option: " + firstOpt)
  println("No option: " + noOption)

  // Unsafe APIs
  def unsafeMethod(): String = null
//  val result = Some(unsafeMethod()) // WRONG
  val result = Option(unsafeMethod())

  println(result)

  // Chained methods
  def backupMethod(): String = "A valid method"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  println(chainedResult)

  //Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid backup")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  println("Better:  " + betterChainedResult)

  // Functions on options
  println(firstOpt.isEmpty)
  println(noOption.isEmpty)

  println(firstOpt.get) // Unsafe
//  println(noOption.get) // Unsafe

  // map, flatMap, and filter
  println(firstOpt.map(_ * 2))
  println(firstOpt.filter(_ > 10))
  println(firstOpt.flatMap(x => Option(x * 10)))

  // for comprehensions

  // Exercise

  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "192.168.10.4",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  println("\nExercise:\n")
  // try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(_.connect)

  println(connectionStatus)
  connectionStatus.foreach(println)

  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection(h, p)
        .map(connection => connection.connect)
      )
    ).foreach(println)

  val forConnectionStatus = for {
    h <- config.get("host")
    p <- config.get("port")
    conn <- Connection(h, p)
  }  yield conn.connect

  forConnectionStatus.foreach(println)
}
