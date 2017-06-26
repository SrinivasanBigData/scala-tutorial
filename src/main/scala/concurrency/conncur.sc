// scala has added its own paradigm on top to java concurrency model using Actor Model
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
// implicits are a feature in scala that allows matching a need to code content.
// here  Future requires an ExecutionContext on which to the thread
// importing this allows to use Futures
// dont usually work well with scala worksheets
//use examples  in command line

val f1 = Future{
  Thread.sleep(1000);50
}

scala> f1
res2: scala.concurrent.Future[Int] = Future(Success(50))

scala>

scala> f1.foreach(n=>println(n))

scala> 50


scala> val f2  = Future { Thread.sleep(1000);3/0}
f2: scala.concurrent.Future[Int] = Future(<not completed>)

  scala> f2.foreach(n=>println(n))

  scala> f2.foreach(n=>println(n))

  scala> f2
  res6: scala.concurrent.Future[Int] = Future(Failure(java.lang.ArithmeticException: / by zero))

  scala> f2.value
  res7: Option[scala.util.Try[Int]] = Some(Failure(java.lang.ArithmeticException: / by zero))


        scala> val ff = f2.failed
        ff: scala.concurrent.Future[Throwable] = Future(Success(java.lang.ArithmeticException: / by zero))

        scala> ff.foreach(n=>println(n))

        scala> java.lang.ArithmeticException: / by zero

//--------------------------------------------
        scala> import scala.concurrent.ExecutionContext
        ExecutionContext   ExecutionContextExecutor   ExecutionContextExecutorService

        scala> import scala.concurrent.ExecutionContext.Implicits.global
        import scala.concurrent.ExecutionContext.Implicits.global

        scala> val f1 = Future{ Thread.sleep(1000);50}
        f1: scala.concurrent.Future[Int] = Future(<not completed>)

        scala> val f2 = f1.map
        map   mapTo

        scala> val f2 = f1.map(n=> n*2)
        f2: scala.concurrent.Future[Int] = Future(<not completed>)

          scala> f2.value // I a'm stiching and asynchronous operation to a another operation which also results in a future
          res0: Option[scala.util.Try[Int]] = Some(Success(100))
          scala> val f3 = f1.filter(_>20)
          f3: scala.concurrent.Future[Int] = Future(<not completed>)

            scala> f3.value
            res1: Option[scala.util.Try[Int]] = Some(Success(50))

            // Promise - the idea of promise is to seperate teh read and write operation from the value
            // the client of the Future will call the get (read operation)
            // once the Future is created and the value is written it will never change - write once read many
            // The Promise represents a place to hold that value - it starts empty and then ends with a value.
            // Promise provides some flexibitly to how the result is handled
        // Futures are write only and promises are read only.
        // you can asmany promises from a future

        scala> val p1 = Promise[Int]
        p1: scala.concurrent.Promise[Int] = Future(<not completed>)

          scala> val p2 = Promise[Int]
          p2: scala.concurrent.Promise[Int] = Future(<not completed>)

            scala> val pf1 = p1.future // creating a future object of the promise
            pf1: scala.concurrent.Future[Int] = Future(<not completed>)

              scala> val pf2 = p2.future // creating a future object of the promise
              pf2: scala.concurrent.Future[Int] = Future(<not completed>)


                scala> val result = for {
                  a <- pf1
                  b <- pf2
                } yield a + b
result: scala.concurrent.Future[Int] = Future(<not completed>)

  scala> result.value // hasn't completed
  res2: Option[scala.util.Try[Int]] = None

  scala> p1.success(3) // promise one has success of 3
  res3: p1.type = Future(Success(3))

  scala> result.value // result is still None as p2 is still waiting
  res4: Option[scala.util.Try[Int]] = None

  scala> p2.success(4) // promise 2 is success 4
  res5: p2.type = Future(Success(4))

  scala> result.value // result is returned becuase both Futures are completed
  res6: Option[scala.util.Try[Int]] = Some(Success(7))
