import java.time.LocalDateTime

object sheet {


  class Point(val x: Double, val y: Double) {
    def apply(str: String) = println(str + " Point")

    //x,y are instance variables - these are immutable
    // declaring them var will make it mutable
    // this is also a constructor to the class - primary constructor

    println(f"Welcome to (${x},${y})") // can have arbitrary code in the body of the class
    // these statements are called every time a constructor is called

    def this() { // is a auxiliary constructor
      this(0, 0)
    }

    private var i = 0.0 // private instance variable
    def move(dx: Double, dy: Double) = new Point(x + dx, y + dy)

    def distanceFromOrigin = math.sqrt(x * x + y * y)

    // the name of the method can also be symbols
    // p.*(2) where p is an instance of Point and is multiplied by 2
    //p * 2
    def *(factor: Double) = new Point(x * factor, y * factor)

    override def toString: String = f"(${x}, ${y})" //formatted string
  }



  val p = new Point(3, 4)
  p.move(10, 20) // returns a new point object
  p.distanceFromOrigin
  //instance variables can be accessed
  p.x // they are not changed becuase they are not mutable
  p.y
  //Always prefer immutable classes

  val p1 = new Point() // calls the auxiliary constructor with instance variables
  // initialised to 0

  // UNIFORM ACCESS PRINCIPLE
  // p.x and p.distanceFromOrigin is instance variable and method respectively
  // UNIFORM ACCESS PRINCIPLE means the user doesn't care/know about the above difference
  // this allows for changing the implementation from instance variable to methods without any impact

  // infix notation x op y is same as x.op(y)
  1 to 10 map (3 * _) filter (_ % 5 == 2)

  p.*(2)
  p * 2

  p("Hello") // the function call notation shown here is because of the apply() in the Point class

}