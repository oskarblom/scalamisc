package org.oskarblom.scalabook.Chapter6

/**
  * Created by Oskar on 2016-01-03.
  */
object RationalRunner {
  implicit def intToRational(x: Int) = new Rational(x)
  def main(args: Array[String]) {
    val res = new Rational(1, 2) + new Rational(2, 3)
    val aux = new Rational(5)
    val gcd = new Rational(66, 42)
    val mult = gcd * 3
    val mult2 = 3 * gcd

    println(res)
    println(aux)
    println(gcd)
    println(mult)
    println(mult2)
  }
}
