object worksheet {
  // use object for singleton and static methods equivalent of java
  object Accounts {
    private var lastNumber = 0
    def newUniqueNumber() = {
      lastNumber += 1
      lastNumber
    }
  }

  Accounts.newUniqueNumber()
  Accounts.newUniqueNumber()

  val  p=Point(3,4) * 3

}

class Point(val x: Double, val y: Double) {
  def apply(str: String) = println(str + " Point")
  private var i = 0.0
  def move(dx: Double, dy: Double) = new Point(x + dx, y + dy)
  def distanceFromOrigin = math.sqrt(x * x + y * y)
  def *(factor: Double) = new Point(x * factor, y * factor)
  override def toString: String = f"(${x}, ${y})"
}

// when singleton object defined in the same source as the class Point
// it becomes a companion object. It is used to implement static like objects
// companion object have access to the private member of its classes
object Point {
  // common to have apply methods in companion object for factory methods
  // this allows to create objects functionally without using the new keyword
  // val  p=Point(3,4) * 3
  def apply(x: Double,y: Double): Point = new Point(x,y)
  def print(): Unit = {
    println()
  }
}