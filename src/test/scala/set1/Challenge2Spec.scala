package set1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Challenge2Spec extends AnyFlatSpec with should.Matchers {

  it should "xor two hex digit string" in {
    val str1 = "1c0111001f010100061a024b53535009181c"
    val str2 = "686974207468652062756c6c277320657965"
    val res = "746865206b696420646f6e277420706c6179"

    Challenge2.solve(str1, str2) should be(res)
  }
}
