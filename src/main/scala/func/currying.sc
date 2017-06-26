
// CLOSURES
// When a function has access to any variable from any enclosing scope
// even if the variable is no longer around whn you call the function
def mulBy(factor: Double) = (x: Double) => factor * x

val triple = mulBy(3) //// function captures the data that it needs
triple(14)
//functions+values for free variables = closures

// currying = take a function that takes two arguments into a function of one argument
def mul(x: Int, y: Int) = x * y
def multOneAtATime(x: Int) = (y: Int) => x * y //curried version
multOneAtATime(3)(14)

// Syntatic Sugaring for scala
def multOneAtATimeScala(x: Int)(y: Int) = x * y

multOneAtATimeScala(3)(14)
//
val a = Array("Hello", "World")
val b = Array("hello", "world")
a.corresponds(b)(_.equalsIgnoreCase(_))
// the b is in one set of parathensis and the equalsIgnoreCase is the second parathensis

// Currying in this example does type inference by understanding the types from the call a.corresponds(b)
// this allows the second function to be declared using functions

// CONTROL STRUCTURES

/*
def runInThread(block: ()=> Unit): Unit ={
  new Thread{
    override def run(): Unit = block()
  }.start()
}


runInThread(()=>println("hello"))
*/

// Scala allows to the above commented code to be refactored to the below
// this is  called call by name parameter
def runInThread(block: Unit): Unit = {
  new Thread {
    override def run(): Unit = block
  }.start()
}

runInThread {println("hello"); Thread.sleep(200); println("bye")}

