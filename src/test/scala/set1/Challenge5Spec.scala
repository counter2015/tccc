package set1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Challenge5Spec extends AnyFlatSpec with should.Matchers {

  it should "encrpt text by repeating-key XOR" in {
    val text = "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal"
    val key = "ICE"
    val res =
      "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"
    Challenge5.keyEncrypt(key, text) should be(res)
  }
}
