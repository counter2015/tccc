package misc

import java.util.HexFormat
import CharacterTable.sentenceScore

object Decrypt {

  extension (bytes: Array[Byte])
    def toHex: String =
      HexFormat.of().formatHex(bytes)
  def textByKey(text: String, key: String): String = {
    val times = (text.length + key.length - 1) / key.length

    val bytes =
      for (a, b) <- text.zip(key.repeat(times).take(text.length))
      yield (a ^ b).toByte

    val res = bytes.toArray.toHex

    res
  }

  def findSingleKey(bytes: Array[Byte]): Byte = {
    val byteRange: Seq[Byte] = (Byte.MinValue to Byte.MaxValue).map(_.toByte)

    (for
      byte <- byteRange
      res = bytes.map(c => (c ^ byte).toChar).mkString
      score = sentenceScore(res)
    yield (byte, score)).minBy(_._2)._1
  }
}
