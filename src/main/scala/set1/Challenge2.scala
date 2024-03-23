package set1

import java.util.HexFormat

object Challenge2:

  extension (str: String)
    def hexToBytes: Array[Byte] =
      HexFormat.of().parseHex(str)

  extension (bytes: Array[Byte])
    def toHex: String =
      HexFormat.of().formatHex(bytes)
  def solve(str1: String, str2: String): String =
    val (h1, h2) = (str1.hexToBytes, str2.hexToBytes)

    val result = h1.zip(h2).map((a, b) => (a ^ b).toByte).toArray
    result.toHex
