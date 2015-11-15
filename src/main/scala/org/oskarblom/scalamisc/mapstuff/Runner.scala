package org.oskarblom.scalamisc.mapstuff

/**
  * Created by oskar on 2015/11/08.
  */
object Runner {

  def flattenIt(): Seq[Int] = {
    val myMap = Map("a" -> Seq(1, 2, 3), "b" -> Seq(4, 5, 6))
    myMap.flatMap(_._2).toSeq
  }
  //TODO: for-yield


  def main(args: Array[String]) {
    val flattened = flattenIt
    println(flattened)
  }
}
