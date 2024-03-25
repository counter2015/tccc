package set1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Challenge4Spec extends AnyFlatSpec with should.Matchers {

  it should "find the correct encoded line from lines" in {
    val res = "Now that the party is jumping\n"

    Challenge4.solve() should be(Some(res))
  }
}
