package set1

import java.util.{Base64, HexFormat}

object Challenge1:
  def solve(str: String): String =
    Base64.getEncoder.encodeToString(HexFormat.of().parseHex(str))


