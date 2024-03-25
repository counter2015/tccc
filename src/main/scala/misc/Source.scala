package misc

import java.io.IOException
import scala.util.{Try, Using}
object Source {

  def fromURLOrResource(url: String, sourcePath: String): Try[Array[String]] =
    fromURL(url).recoverWith { case e: IOException =>
      fromResource(sourcePath)
    }

  def fromURL(url: String): Try[Array[String]] =
    Using(scala.io.Source.fromURL(url)) { source =>
      source.getLines().toArray
    }

  def fromResource(sourcePath: String): Try[Array[String]] =
    Using(scala.io.Source.fromResource(sourcePath))(source => source.getLines().toArray)

}
