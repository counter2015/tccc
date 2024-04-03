package set1

import misc.HammingDistance.ofKeyLengthNormalized
import misc.Decrypt

import java.util.Base64

object Challenge6:

  def guessKeyLength(text: String): Int =
    val ress = (1 to 40).map(n => (n, ofKeyLengthNormalized(n, text)))
    ress.minBy(_._2)._1

  def keyDecrypt(key: String, text: String): String =
    val kn = key.length
    String(text.zipWithIndex.map { case (c, i) => (c ^ key(i % kn)).toByte }.toArray)

  def solve(): Option[String] =
    util
      .Using(io.Source.fromResource("s1c6.txt")) { source =>
        val textBase64 = source.getLines().mkString
        val text = String(Base64.getDecoder.decode(textBase64))

        val keyLength = guessKeyLength(text)

        val byteList = text.grouped(keyLength).map(_.getBytes).toArray
        // Terminator X: Bring the noise
        val key = String(byteList.transpose.map(Decrypt.findSingleKey))

        val res = keyDecrypt(key, text)

        res
      }
      .toOption
