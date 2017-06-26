package interop

/**
  * Created by jubin on 6/26/2017.
  */
class Test {
  def func1(){println("func1 class")}
}
object Test{
  def func2(){println("func2 object")}
  def func1(){println("func1 object")}
}
