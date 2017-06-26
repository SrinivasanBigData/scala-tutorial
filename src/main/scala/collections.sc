//Arrays - when declaring arrays you have to say what you are collecting
val nums = new Array[Int](10)

// no new to specify the collection of items
val a = Array("Hello", "Bye")

//accessing the array
a(0)
for (element <- a) println(element)

// traverse by index
for (i <- 0 until a.length) print(a(i) + " ")
a

//In the the JVM the scala Array is a java Array int[], String[]
// scala compiler will move Int[] tp the respective primitive int[]
// this allows for interoperability

// in scala the variable array is implemented as ArrayBuffer
import scala.collection.mutable.ArrayBuffer //analogous of ArrayList
val b = new ArrayBuffer[Int]
b += 1 //+= append to the end
b += (1, 2, 3, 4)
b ++= Array(8, 13, 21)
b += 2

// in scala elements of a collection is transformed and create a new array
// as opposed to converting the array elements

val arr = Array(13, 24, 2, 3, 5, 7, 11)
val result = for (element <- arr if element % 2 != 0) yield 2 * element
arr
// algorithms
arr.sum
arr.sorted //return a new collection of elements that are sorted and doesn't mutate exiting array
arr.reverse
arr.mkString("[", ",", "]")

// Maps and tuples
val scores = Map("Alice " -> 10, "Bob" -> 3, "Cindy" -> 8) //immutable

var mScores = scala.collection.mutable.Map("Alice" -> 10)
mScores.put("Bob", 3)
//mScores("Bob") = 20 // cannot access Keys not there will throw exception
mScores
mScores("Alice") // returns the value on this key
// scores("Fred") - throws NoSuchElementException
scores.getOrElse("Fred", 3) // return orElse if "Fred: isnt in map

// scala advises to use immutable map

mScores = mScores - "Alice"
for ((k, v) <- scores) yield (v, k) // flip key and value
scores.keySet
scores.values
//Tuple - collects values of different types unlike and array.
// An Array collection of similar types
val tup = (1, 2.334, "Jubin")
tup._2 // returns second component
// tuples are 1 based unline arrays which are 0 based
tup._1
// pattern matching can be used to access components of a tuple
val (_, second, third) = tup //_ means not intrested,


def removeAllButFirst(arr1: ArrayBuffer[Int]): ArrayBuffer[Int] = {
  for (i <- (for (i <- 0 until arr1.length if (arr1(i) < 0)) yield i).drop(1).reverse) arr1.remove(i)
  arr1
}

val array = new ArrayBuffer[Int]()
array ++= Array(3, 2, -9, 0, -3, 2, -1, -3)
removeAllButFirst(array)