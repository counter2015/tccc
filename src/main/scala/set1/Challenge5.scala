package set1

import misc.Decrypt
object Challenge5:
  def keyEncrypt(key: String, text: String): String =
    Decrypt.textByKey(text, key)
