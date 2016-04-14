import akka.stream.scaladsl.{Flow, Sink, Source}

object Example2 extends App with Examples {

  /*
    Connect a source to a sink with an intermediate flow
   */
  val source = Source(1 to 100)
  val flow = Flow.fromFunction[Int, String](i => if(i % 2 == 0) "even" else "odd")
  source via flow runWith Sink.foreach(println)

}