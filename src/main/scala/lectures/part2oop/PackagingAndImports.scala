package lectures.part2oop

import playground.{AnotherDummy, Dummy => DummyAlias}

import java.util.Date
import java.sql.{Date => SQLDate}

object PackagingAndImports extends App {
  val writer = new Writer("John", "Doe", 2018)

//  val dummy = new playground.Dummy
  val dummy = new DummyAlias

  sayHello

  println(RANDOM_VAL)

  val date = new Date
  val sqlDate = new SQLDate(2020, 1,3)

}
