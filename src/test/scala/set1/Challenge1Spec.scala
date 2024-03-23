package set1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Challenge1Spec extends AnyFlatSpec with should.Matchers {

  it should "convert hex to base64" in {
    val str = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
    val res = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"

    Challenge1.solve(str) should be(res)
  }
}
