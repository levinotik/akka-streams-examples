import akka.stream.ThrottleMode
import akka.stream.scaladsl.{Sink, Source}

import scala.language.postfixOps

object Example6 extends App with Examples {

  import scala.concurrent.duration._
  /*
    Throttle the source so that the downstream sink only processes n elements per some time period

    From docs:

   * Throttle implements the token bucket model. There is a bucket with a given token capacity (burst size or maximumBurst).
   * Tokens drops into the bucket at a given rate and can be `spared` for later use up to bucket capacity
   * to allow some burstiness. Whenever stream wants to send an element, it takes as many
   * tokens from the bucket as number of elements. If there isn't any, throttle waits until the
   * bucket accumulates enough tokens. Bucket is full when stream just materialized and started.

    see https://www.wikiwand.com/en/Token_bucket

    Mode sets whether throttle fails when upstream is faster than throttle rate (Enforcing) or if throttle pauses
    to meet specified rate (Shaping)
   */

  val source = Source(1 to 1000).throttle(elements = 10, per = 1 second, maximumBurst =  50, mode = ThrottleMode.Shaping)
  source runWith Sink.foreach(println)

}