package org.oskarblom.scalamisc.forcomp

/**
  * Created by oskar on 2015/11/08.
  */
object Runner {

  def main(args: Array[String]) {

    val nested = List(List("a", "b", "c"), List("d", "e", "f"))

    for (
      letters <- nested;
      letter <- letters
    ) println(letter)

    for {
      letters <- nested
      letter <- letters
    } println(letter)
  }
}
