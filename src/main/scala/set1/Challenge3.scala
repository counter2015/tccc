package set1

import misc.CharacterTable.sentenceScore
import Challenge2.hexToBytes

object Challenge3:
  def solve(str: String): String =
    val candidateScores =
      for i <- Byte.MinValue to Byte.MaxValue
      yield
        val decoded = str.hexToBytes.map(_ ^ i).map(_.toByte)
        val text = new String(decoded)
        (text, sentenceScore(text))

    candidateScores.minBy(_._2)._1
