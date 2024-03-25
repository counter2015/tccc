package set1

import misc.CharacterTable.sentenceScore
import Challenge2.hexToBytes

object Challenge3:
  def solveSingeLine(line: String): (String, BigDecimal) =
    val candidateScores: Seq[(String, BigDecimal)] =
      for i <- Byte.MinValue to Byte.MaxValue
      yield
        val decoded: Array[Byte] = line.hexToBytes.map(_ ^ i).map(_.toByte)
        val text = new String(decoded)
        (text, sentenceScore(text))
    candidateScores.minBy(_._2)
  def solve(str: String): String =
    solveSingeLine(str)._1
