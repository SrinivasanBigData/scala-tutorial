
val n = 3
n match { //n.match({...})
  case 1 | 3 | 5 => println("Its odd") //allows of alternation
  case 2 | 4 | 6 => println("Its even") // the case values dont need tobe compile time constants
  case m => println("its variable")
  case _ => println("Something else") // default case
}
// unlike switch there is no break

// matching on types of values
// Any is the topmost type in scala
def doIt(x: Any) = x match {
  case _: Int => println("Type Int")
  case _: String => println("Type is String")
  case _ => println("this is something else")
}

doIt(2)
doIt("Jubin")
doIt(3.2)

// here we extract values
def doIt2(x: Any) = x match {
  case n: Int => println(s"Type Int $n") //string interpolation
  case s: String => println(s"Type is String $s")
  case default => println(s"this is something else $default")
}

doIt2(n)
doIt2("abc")
doIt2(23.2)
// matching multiple arguments
def doIt3(a: Int, b: Int) = (a, b) match {
  case (1, 1) => println("1,1")
  case (1, _) => println("matching 1")
  case (_, 2) => println("matching second")
  case (_,_) => println("Anything else")
}

doIt3(1,2)
doIt3(4,3)

val zero = BigInt(0)
def fact(n: BigInt): BigInt = n match {
  case `zero` => 1
  case m => m * fact(n-1)
}

fact(50)