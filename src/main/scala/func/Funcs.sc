import scala.math._
//
// passing functions as value
val num = 3.14
val fun = ceil _ // ceil function is assigned to a value
fun(num) // fun delegates the call to the the underlying function
Array(3.14, 1.42, 2.0).map(fun) // here fun is passed to each number in the array
// since functions are first class they can be stored/called and given to other function methods

// you can also give anonymous functions
Array(3.14, 1.42, 3.9).map((x: Double) => 3 * x)

def triple(x: Double) = 3 * x
Array(3.14, 1.42, 3.9).map(triple)

// defining function with function parameters
// f is the function name passed to the argument of valueAtOneQuarter and is used to call the function
// f takes a double and returns a double
//valueAtOneQuarter always call such a function with 0.25
def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

// the result of the below is 0.25 * 200
valueAtOneQuarter((x: Double) => x * 200)
valueAtOneQuarter(sqrt _) // _ is used to treat a method as a function. If you had passed a function there was no need for _


// Function that produces function
def mulBy(factor: Double) = (x: Double) => factor * x
val quintuple = mulBy(5) // creates a function that multiplies by 5
quintuple(20) // the quintuple  by defualt multiplies anything by 5

// syntax optimization
//scala can infer parameter types valueAtOneQuarter cal also be written as
valueAtOneQuarter((x) => x * 200) // here double is inferred from the function definition
valueAtOneQuarter(x => x * 200) // if its a single parameter you can remove () altogether
//if the parameter variable occurs just once, it can be replaced with _
valueAtOneQuarter(_ * 200)

