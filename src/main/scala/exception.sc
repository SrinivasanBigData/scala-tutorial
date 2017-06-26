

//null is not a good idea.
// Option is used to indicate the absence of a value
val opt = Some(1)
val none = None
// when you create a option its going to be either Some on None
opt.get

// the second parameter is an option of string
case class User(name: String, _city: Option[String])

val user1 = new User("Fred", Some("London")) // has value
val user2 = new User("jil", None) // no value ofr city

// by using Option we are saying the argument could hold null / missing information
user1._city.getOrElse("No city")
user2._city.getOrElse("No city")

//using destructuring
def getCity(u: User) = u._city match {
  case Some(c) => c
  case None => "No City"
}
getCity(user1)
getCity(user2)

val users = List(User("jil", Some("Edinburgh")),
  User("dave", None),
  User("paul", Some("Shanghai")),
  User("marie", None))

val cities = users.flatMap(x => x._city) // removes Options and None syntax and returns actual values

//EXCEPTION
// Is an side-effect to a function
val s = "12s3"
try {
  val n = s.toInt
} catch {
  case ex: NumberFormatException => println(ex.toString)
}
// in scala don't let exception propogate
// scala doesn't support checked exception

import scala.util.{Failure, Success, Try}

val s1 = "1233"
val v1 = Try {
  s1.toInt
} // Failure(java.lang.NumberFormatException: For input string: "1233e")
//else v1: scala.util.Try[Int] = Success(1233)
// this basically divorced the idea of exception from the mechanism that handle it.

// I can use pattern matching to handle Success and failure seperately.
v1 match {
  case Success(n) => println(n)
  case Failure(ex) => println(ex.getMessage)
}


val ss = "123x"
val s2 = "456"

val result = for {
  n <- Try{ss.toInt}
  m <- Try{s2.toInt}
} yield m+n

// The above code if ss throws an exception then s2.ToInt isnt executed either
// the process is aborted

