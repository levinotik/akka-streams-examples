import akka.stream.scaladsl.{Sink, Source}

object Example1 extends App with Examples {

  /*
      Just connect a source to a sink
   */
  val source = Source(1 to 100)

  /*
    runWith connects source to a sink and run it
   */
  source runWith Sink.fold(0)(_ + _) foreach println
}
