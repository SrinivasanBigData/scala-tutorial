import scala.annotation.tailrec

// methods are defined in classes but functions are defined anywhere
def abs(x: Double) = if (x >= 0) x else -x
// returned type is infered as double
// abs: abs[](val x: Double) => Double

//recursive functions the return type is not inferred, its explicit def fac(n: Int): Int
def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

// if omit the = the function doesnt return anything
// the return type is a unit / void
def box(s: String): Unit = {
  val border = "-" * s.length + "--\n"
  println(border + "|" + s + "|\n" + border)
}
box("hello")

//if I miss the = in the below fac1(n:Int)={} then I would get a void/unit return
def fac1(n: Int) = {
  var r = 1
  for (i <- 1 to n) r = r * i
  r
}
fac(10)

// defualt arguments are passed as below

def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
decorate("Hello")
decorate("Hello", ">>>[")
decorate("Hello", right = "]<<<") // named default parameters are also allowed

// varargs
def sum(args: Int*) = { //args is Seq[Int]
  var result = 0
  for (arg <- args) result += arg
  result
}
sum(1, 3, 45, 2, 3)

// if the argument is a sequence then
//sum (1 to 10) illegal as the argument isnt type safe - this is allowed in Java

// this can be overriden by
sum(1 to 10: _*) //_* means consider this as a sequence of something

// the above feature could be valuable in recursive functon calls as below
def recursiveSum(args: Int*): Int = {
  if (args.length == 0) 0
  else args.head + recursiveSum(args.tail: _*)
}

recursiveSum(1, 3, 45, 2, 3)


// LAB1

def isVowel(ch: Char, vowels: String = "AEIOU", ignoreCase: Boolean = true) = {
  if (!ignoreCase)
    vowels.toCharArray.contains(ch)
  else
    vowels.toUpperCase.toCharArray.contains(ch.toUpper)
}

isVowel('B')
isVowel('A')
isVowel('a')

def vowels(s: String) = for (c <- s if isVowel(c)) yield c


vowels("nicaragua")

def vowelsRecursive(s: String): String = {
  if (s.length == 0) ""
  else {
    val ch = s.head
    val rest = vowelsRecursive(s.tail)
    if (isVowel(ch)) ch + rest else rest
  }
}

vowelsRecursive("nicaragua")
vowels("übeltäter gehör")
def vowelsdef(s: String, alsoVowels: String = "aeiou", ignoreCase: Boolean = true) =
  for (c <- s if (isVowel(c, alsoVowels, ignoreCase))) yield c

vowelsdef("übeltäter gehör", "aeiouöüä")
vowelsdef("übeltäter gehör", "aEiouöüä", false)

/*
In traditional recursion, the typical model is that you perform your recursive calls first,
and then you take the return value of the recursive call and calculate the result.
In this manner, you don't get the result of your calculation until you have returned from every recursive call.

In optimised tail recursion, you perform your calculations first, and then you execute the recursive call,
 passing the results of your current step to the next recursive step.

The consequence of this is that once you are ready to perform your next recursive step,
you don't need the current stack frame any more. This allows for some optimization.
In fact, with an appropriately written compiler, you should never have a stack overflow snicker with a tail recursive
call. Simply reuse the current stack frame for the next recursive step.

 Java doesn't optimize for tail recursion if the bytes code indicates recursion.
 scala has a trick - the scala compiler has a mechanism to detect tail recursion and then automatically eleminatng it

 */

// scala identifies this code as tail recursive and does the optimization of changing
// it to a loop
def fact(n: Int, acc: Int): Int = n match {
  case 0 => acc
  case m => fact(m - 1, m * acc)
}

fact(4, 1)

// this can be further optimised to ->
def factorial(m: Int): Int = {
@tailrec  def fact(n: Int, acc: Int): Int = n match {
  //@tailrec lets developer know its optimized for tailrec
    // if the implementation changes to pure recursion then the compiler cries
    case 0 => acc
    case m => fact(m - 1, m * acc)
  }
  fact(m, 1)
}

factorial(5)
