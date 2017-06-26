object sc{
//Case classes
  // Let's say you need to write a library that manipulates arithmetic expressions,
  // perhaps as part of a domain-specific language you are designing.
// A first step to tackle this problem is the definition of the input data.
// To keep things simple, we'll concentrate on arithmetic expressions consisting of variables,
// numbers, and unary and binary operations. This is expressed by the hierarchy of Scala classes shown below
  //http://www.artima.com/pins1ed/case-classes-and-pattern-matching.html

  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String,left: Expr, right: Expr) extends Expr

// each subclass has a case modifier. Classes with such a modifier are called case classes.
  // Using the modifier makes the Scala compiler add some syntactic conveniences to your class

  val v = Var("x")
  // The apply() implementation comes by default, so new is not necessary to instantiate the class
  val op = BinOp("+",Number(1),v)
  //The second syntactic convenience is that all arguments in the parameter list of a case class implicitly get a val prefix
  v.name
  op.left
  /*
  Third, the compiler adds "natural" implementations of methods toString, hashCode, and equals to your class.
  They will print, hash, and compare a whole tree consisting of the class and (recursively) all its arguments.
  Since == in Scala always forwards to equals, this means in particular that elements of case classes
  are always compared structurally:
   */

  println(op)

  op.right == Var("x")
  /*
  All these conventions add a lot of convenience, at a small price.
  The price is that you have to write the case modifier and that your classes and objects become a bit larger.
  They are larger because additional methods are generated and an implicit field is added for each constructor parameter.
  However, the biggest advantage of case classes is that they support pattern matching.
 */


}