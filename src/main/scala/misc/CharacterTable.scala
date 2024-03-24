package misc

object CharacterTable {
  // https://www3.nd.edu/~busiforc/handouts/cryptography/letterfrequencies.html
  val table: Map[String, BigDecimal] = Map(
    "E" -> 11.1607,
    "M" -> 3.0129,
    "A" -> 8.4966,
    "H" -> 3.0034,
    "R" -> 7.5809,
    "G" -> 2.4705,
    "I" -> 7.5448,
    "B" -> 2.0720,
    "O" -> 7.1635,
    "F" -> 1.8121,
    "T" -> 6.9509,
    "Y" -> 1.7779,
    "N" -> 6.6544,
    "W" -> 1.2899,
    "S" -> 5.7351,
    "K" -> 1.1016,
    "L" -> 5.4893,
    "V" -> 1.0074,
    "C" -> 4.5388,
    "X" -> 0.2902,
    "U" -> 3.6308,
    "Z" -> 0.2722,
    "D" -> 3.3844,
    "J" -> 0.1965,
    "P" -> 3.1671,
    "Q" -> 0.1962
  )

  /** Calculate the score of a string based on the character table.
    *
    * @param s
    *   the string to calculate the score of
    * @return
    *   the score of the string, lower is better
    */
  def sentenceScore(s: String): BigDecimal =
    val partialTable = s.toCharArray.view.distinct
      .map(_.toString.toUpperCase)
      .filter(table.keySet.contains)
      .map(key => key -> table(key))
      .toMap

    val total: BigDecimal = partialTable.values.sum

    val partialNormizedTable: Map[String, BigDecimal] =
      // here we use a default value zero to ingore no-letter characters
      partialTable.map { case (key, value) => (key, value / total) }.withDefaultValue(BigDecimal(0.0))

    val length: Int = s.length

    val score: BigDecimal = s.toCharArray
      .groupMapReduce(_.toString)(_ => 1)(_ + _)
      .map { case (key, value) =>
        val expected = partialNormizedTable(key.toUpperCase())
        val diff = value / BigDecimal(length) - expected
        diff * diff
      }
      .sum

    score
}
