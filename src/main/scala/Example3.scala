import akka.stream.scaladsl.{Sink, Source}

object Example3 extends App with Examples {

  /*
    Create a source from an Iterator. Could be used, for example, to read from a queue somewhere using a
    blocking Java client. Here we just print each message from the queue, but you could build a
    pipeline to do complex processing of those messages.
   */
  def readFromSomeQueue: String = scala.util.Random.alphanumeric.take(7).mkString

  val source = Source.fromIterator(() => Iterator.continually(readFromSomeQueue))
  source runWith Sink.foreach(println)

}