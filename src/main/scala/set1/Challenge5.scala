package set1

import set1.Challenge2.toHex
object Challenge5:
  def keyEncrypt(key: String, text: String): String =
    val times = (text.length + key.length - 1) / key.length

    val bytes =
      for (a, b) <- text.zip(key.repeat(times).take(text.length))
      yield (a ^ b).toByte

    val res = bytes.toArray.toHex

    res
