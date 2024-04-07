package set1

import misc.Decrypt.AESDecryptBase64Data

object Challenge7:
  def decrypt(data: String, key: String): String =
    AESDecryptBase64Data(data, key)
