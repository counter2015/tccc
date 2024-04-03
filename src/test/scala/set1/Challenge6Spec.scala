package set1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Challenge6Spec extends AnyFlatSpec with should.Matchers {

  it should "break repeating-key XOR" in {
    val res = scala.io.Source.fromResource("s1c6_result.txt").getLines().mkString("\n")
    Challenge6.solve() should be(Some(res))
  }
}
