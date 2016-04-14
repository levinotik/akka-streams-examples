import akka.stream.scaladsl.{Sink, Source}

object Example4 extends App with Examples {

  /*
    Same as previous example but we only take 10 elements from the source
   */
  def readFromSomeQueue: String = scala.util.Random.alphanumeric.take(7).mkString

  val source = Source.fromIterator(() => Iterator.continually(readFromSomeQueue))
  source take 10 runWith Sink.foreach(println)

}