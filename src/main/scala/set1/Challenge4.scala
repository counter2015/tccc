package set1

import set1.Challenge3.solveSingeLine
import misc.Source.fromResource

object Challenge4:
  def solve(): Option[String] =
    val resourceFilePath: String = "s1c4.txt"
    val lines = fromResource(resourceFilePath).toOption

    val res = lines match
      case None         => None
      case Some(values) =>
        Option(values.map(solveSingeLine).minBy(_._2)._1)

    res
