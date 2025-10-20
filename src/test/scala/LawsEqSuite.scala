import org.scalatest.funsuite.AnyFunSuite


class EqLawsSuite extends AnyFunSuite:
  import MainCheck.EqLaws._
  import MainCheck.Eq

  given eqInt: Eq[Int] = Eq.instance((x, y) => x == y)

  test("symmetry law should hold for Int"):
    assert(symmetry(10, 11))

  test("reflexivity law holds for Int"):
    assert(reflexivity(12))

  test("transitivity law holds for Int"):
    assert(transitivity(3, 3, 3))