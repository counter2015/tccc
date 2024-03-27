package misc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
class HammingDistanceSpec extends AnyFlatSpec with should.Matchers {

  it should "caculate ditance of two byte" in {
    val b1: Byte = 0x1
    val b2: Byte = 0x2

    HammingDistance.ofTwoByte(b1, b2) should be(2)
  }

  it should "caculate ditance of two string" in {
    val str1 = "this is a test"
    val str2 = "wokka wokka!!!"
    val res = 37

    HammingDistance.ofTwoString(str1, str2) should be(res)
  }
}
