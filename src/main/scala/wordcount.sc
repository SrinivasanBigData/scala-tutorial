
/*
val in = new java.util.Scanner(
  new java.net.URL("http://horstmann.com/presentations/livelessons-scala-2016/alice30.txt")
    .openStream())

var count = Map[String, Int]()
while (in.hasNext()) {
  val word = in.next()
  count = count + (word -> (count.getOrElse(word, 0) + 1))
}
count.size
count("Alice")
count("Rabbit")*/

val words = Array("Mary", "had", "a", "little",
  "lamb", "its", "fleece", "was",
  "white", "as", "snow", "and",
  "everywhere", "that", "Mary", "went",
  "the", "lamb", "was", "sure",
  "to", "be")

var map = words.groupBy(_.length)
map.keySet.mkString(",")

val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)
for ((k,v) <- pairs) print(k*v)



"New York".partition(_.isUpper) // returns a pair of two strings
// the first is a string of uppercase strings and the second is lower strings
var buff = Array(1, 2, -9, 4, 3, -2, -7, 1, -3)
val (neg,pos) = buff.partition(_ < 0)


