import java.time.LocalDate

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

class CurrentAccount{
  private var balance: Double = 0

  def withdraw(amount: Double) {
    if (amount > balance)
      println("error")
    else balance -= amount
  }

}

// traits also work like extensions in .NET
// Current accout is injected with logging abilities although it doesnt implement the log method
val curr = new CurrentAccount() with ConsoleLogger
curr.log("Hell")

