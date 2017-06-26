// packages are used to give unique names to classes
// no relation ship between packages and source dir
// packages are nested
package jtk {
  package yo {

    object sc {
      def increment(i: Int) = i + 1
    }

  }

}

// you can multiple packages in the same source file
//imports
// _ is the wild card for Scala
import java.time.LocalDate
import java.util.{HashMap => JavaHashMap, Vector => _} //hide the class. imports everything in java.util but Vector
//Subclass declaration like Java
object sc {

  class A(a: Int) {

  }

  class B(a: Int, b: Int) extends A(a) { // calling the constructor of A

  }

  val a = new A(2);
  val b = new B(1, 2);

  a.isInstanceOf[A]
  a.isInstanceOf[B]
  b.asInstanceOf[A]
  b.getClass == classOf[A]
  a.getClass == classOf[B]
  a.getClass == classOf[A]


  // traits are like interfaces but better
  // A class can implement multiple traits

  class C(a: Int, b: Int) extends B(a, b) with Serializable with Cloneable {

  }

  // TRAITS can have abstract fields
  // traits can have concrete fields
  // traits cannot have construction parameters.
  // traits can extend other traits

  //Mixin

  trait Logged {
    def log(msg: String) {}
  }

  trait ConsoleLogger extends Logged { // this is the implementation of Logged Trait
    override def log(msg: String) {
      println(msg)
    }
  }

  trait TimestampLogger extends Logged{
    // super.log in a trait depends on the kind of trait its assigned with
    override def log(msg: String): Unit = super.log(LocalDate.now() +" : "+ msg)
  }

  trait ShortLogger extends Logged{
    val maxLength=15

    override def log(msg: String): Unit ={
      super.log(
        if(msg.length<=maxLength) msg
        else msg.substring(0,maxLength -3) + "..."
      )
    }
  }

  class SavingsAccount extends Logged { //unlike interfaces we also extend Logged Trait
    // you will see there is no implementation of Logged abstract method
    private var balance: Double = 0

    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }

  val acc = new SavingsAccount with ConsoleLogger // construction of Saving you can assign the correct trait with the with statement
  // this is called Mixin
  acc.withdraw(100)

  // trait methods can invoke other in a prior layer
  // this gets executed in the reverse order from ShortLogger -> TimeStampLogger -> ConsoleLogger
  val acc1 = new SavingsAccount with ConsoleLogger
    with TimestampLogger
    with ShortLogger
  acc1.withdraw(500)

  // you can override the last trait for custom behaviour
  val acc2 = new SavingsAccount with ConsoleLogger
    with TimestampLogger
    with ShortLogger{
    override val maxLength: Int = 100
  }
  acc2.withdraw(500)


  trait Vehicle {
    def launch
  }
  trait Boat extends Vehicle{
    override def launch = println("I'am a boat")
  }
  trait Boat2 extends Vehicle{
    override def launch = println("I'am another boat")
  }

  trait Plane extends Vehicle{
    override def launch = println("I'am a plane")
  }
  class SeaPlane extends Vehicle{
    override def launch: Unit = println("I'am a seaplane")
  }
  val s = new SeaPlane with Boat with Plane;
  s.launch // will search for the method starting from the right most trait
  // this is called trait linearization

  

}