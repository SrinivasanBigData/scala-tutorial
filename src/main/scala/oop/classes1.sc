import java.time.LocalDateTime

object ws{

  class Pet{
    def feed()={
      "Feeding at " + LocalDateTime.now()
    }
  }

  class Cat extends Pet{
    def hunt()={
      println("The cat hunts")
    }
  }

  val c = new Cat()
  println(c.feed())

  var p: Pet = new Cat(); // staticly typed to Pet but runtime to Cat

  class Dog extends Pet{
    override val feed = "Dog feeding..." // subclass should provide the most specific behaviour
    // the method is converted to a val
  }


}