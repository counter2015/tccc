package set1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Challenge3Spec extends AnyFlatSpec with should.Matchers {

  it should "decode xor bit text" in {
    val str = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
    val res = "Cooking MC's like a pound of bacon"

    Challenge3.solve(str) should be(res)
  }
}
