object sheet1{
 val x = 4
  val result = if(x>0) 1 else -1 // if is like the tertiary operator in java
  val result1 = if(x>0) "Yo" else -1 // since the return can be string or int it returns
  // Any - which is equivalent to object

  val y = -2
  val result2 = if(y>0) "hello" // returns Any = ()
  val result3 = () // is a type Unit. This equivalent to void in Java

  var x0 = 5
  var y0 = 6
  //value of a block of statement is the value of the last statement
  val distance = {
    val dx = x - x0
    val dy = y - y0
    import scala.math._
    sqrt(dx*dy + dy*dy)
  }

  //distance: Double = 8.48528137423857

  // scala doesnt have three part loop for (i=1;i<9;i++)
  val n=3
  for (i <- 1 to n)println(i)

  // this works for any collection
  for(c <- "hello")println(c)

  // having more than one of these arrows expression (generators)

  for(i<- 1 to 3; j <- 1 to 3)print((10*i+j) + " ")

  // guard  if i!=j
  for(i<- 1 to 3; j <- 1 to 3 if i!=j )print((10*i+j) + " ")

  //collecting results
  for(i <- 1 to 10) yield i % 3 // yield collects the results of each iteration into a list a map would do
  1.to(10).map(_%3) // same result as above
  

}