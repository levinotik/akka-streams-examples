import akka.stream.scaladsl.{Sink, Source}
import scala.concurrent.Future

object Example5 extends App with Examples {

  /*
    Create a source from a Future
   */

  val source = Source.fromFuture(Future(scala.io.Source.fromURL("https://httpbin.org/get").mkString))
  source runWith Sink.foreach(println)

}