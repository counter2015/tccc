package misc

object HammingDistance {
  
  def ofKeyLengthNormalized(n: Int, text: String): Double = {
    val block0 = text.take(n)
    val res = text.grouped(n).filter(_.length == n).map(ofTwoString(_, block0)).sum * 1.0 / text.length
    res
  }

  def ofTwoString(str1: String, str2: String): Int = {
    assert(str1.length == str2.length, "the string length should be equal")
    str1.zip(str2).map((a, b) => ofTwoByte(a.toByte, b.toByte)).sum
  }

  def ofTwoByte(b1: Byte, b2: Byte): Int = {

    def paddedBinaryString(b: Byte): String = {
      val binaryString = b.toInt.toBinaryString
      val padding = "0" * (8 - binaryString.length)
      padding + binaryString
    }

    val str1 = paddedBinaryString(b1)
    val str2 = paddedBinaryString(b2)

    str1.zip(str2).map((a, b) => a ^ b).sum
  }

}
