import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

trait Examples {

  implicit val ec = scala.concurrent.ExecutionContext.Implicits.global
  implicit lazy val system = ActorSystem("streams-examples")
  implicit val materializer = ActorMaterializer()
}
