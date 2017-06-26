import java.time.LocalDateTime

// the two types that java has is primitive values and object reference
case class Cashflow(amout: Double, currency: String, due: LocalDateTime)

// case classes are immutable value types
val c1 = Cashflow(3000.0, "GBP", LocalDateTime.now())

//destructing matches
c1 match {
  case Cashflow(v, "USD", _) => println("US cashflow")
  case Cashflow(v, "GBP", _) => println(s"UK cashflow of $v")
}

case class Address(city: String, country: String)

case class Person(name: String, age: Int, address: Address)

val a1 = Address("London", "UK")
val a2 = Address("New York", "US")
val p1 = Person("fred", 41, a1)
val p2 = Person("jane", 22, a2)

// u can take nested classes and match in various combinations
p1 match {
  case Person(n, _, Address("London",_) ) => println (s"$n lives in London")
}

// matching with gaurds

p2 match {
  case Person(n,a,_) if a>30 => println(s"$n is older than 30")
  case Person(n,a,_) if a <= 30 => println(s"$n is  a youngster")
}

// case classes have a apply method described
