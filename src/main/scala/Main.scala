object MainCheck extends App {


  case class Person(id: Int, firstName: String, lastName: String)

  trait Eq[A] {
    def eqv(x: A, y: A): Boolean
    final def neqv(x: A, y: A): Boolean = !eqv(x, y)
  }



  object Eq:
    def instance[A](f: (A, A) => Boolean): Eq[A] =
      new Eq[A]:
        def eqv(x: A, y: A): Boolean = f(x, y)

    def by[A, B](f: A => B)(using eqB: Eq[B]): Eq[A] =
      instance[A]((x, y) => eqB.eqv(f(x), f(y)))


  extension [A](x: A)
    def === (y: A) (using eq: Eq[A]): Boolean = eq.eqv(x, y)
    def =!= (y: A)(using eq: Eq[A]): Boolean = eq.neqv(x, y)


  object EqLaws:

    given eqA[A]: Eq[A] = Eq.instance((x, y) => x == y)

    def reflexivity[A](x: A)(using eq: Eq[A]): Boolean =
      x === x

    def symmetry[A](x: A, y: A)(using eq: Eq[A]): Boolean =
      (x === y) === (y === x)

    def transitivity[A](x: A, y: A, z: A)(using eq: Eq[A]): Boolean =
      (x === y) === (y === z) === (x === z)

}



