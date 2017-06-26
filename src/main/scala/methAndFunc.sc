
// val sqaure is an object
val square = (n: Int) => n * n
// functions have types


object Test{
  def f(n:Int)=n+n // methods are always part of class or object
  // method have signatures
}
val f1 = (n: Int) => Test.f(n)
f1(2)
//this can be written as
val f2 = Test.f _ // same as = (n: Int) => Test.f(n)
// these are called partial function application
