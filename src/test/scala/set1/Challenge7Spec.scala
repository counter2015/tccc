package set1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Challenge7Spec extends AnyFlatSpec with should.Matchers {

  private def compileLines(l1: Array[String], l2: Array[String]): Boolean =
    l1.zip(l2).forall(x => x._1.trim == x._2.trim)

  it should "works on AES-128-ECB decryption" in {

    val data = scala.io.Source.fromResource("s1c7.txt").getLines().mkString
    val key = "YELLOW SUBMARINE"
    val fc = Challenge7.decrypt(data, key)
    val res = scala.io.Source.fromResource("s1c7_result.txt").getLines().mkString("\n")

    val l1 = res.split("\n")
    val l2 = fc.split("\n")
    compileLines(l1, l2) should be(true)
  }
}
