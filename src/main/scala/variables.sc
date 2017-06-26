object sheet1 {
  println("Woelcome to scala worksheet")
  8 * 5 + 2
  val answer = 8 * 5 + 2 // type is inferred
  // val is a immutable variable
  //answer = 3 //illegal
  var response = 34 //var is mutable
  response = 42
  //response=34.3 illegal type is inferred as int already

  // There are no primitive types in scala - everything is a object
  var greeting: String = null; //; is optional
  var a: Int = 3

  greeting = "bye"

  //  sala datatypes Int, Double, Byte, Char, Short, Long, Float, Boolean

  1.to(10)
  // in scala String is the same as java.lang.String
  // but there are a so many more methods in String
  "Hello".intersect("Hellboy") // these methods are augmented in StringOps

  val x: BigInt = 23432423
  x * x * x * x // similar to BigInteger in Java

  // two ways of writing method call
  1.to(100)
  1 to 100 // works for methods with one parameter
  val result = 1.+(100) // here + is the name of the method

  //++,-- doesnt exist in scala instead use +=

  lazy val y = {
    println("y"); 13
  } //lazy means the value on the right side will be executed when itis accessed



}