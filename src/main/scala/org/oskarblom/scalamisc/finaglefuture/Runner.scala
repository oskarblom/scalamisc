package org.oskarblom.scalamisc.finaglefuture

import com.twitter.util.{Await, Future}

/**
  * Created by oskar on 2015/11/16.
  */



object Runner {
  def main(args: Array[String]) {
    val foo = Future.value(3)
    foo.foreach(println)
    val r = foo.map(f => f)
    println(Await.result(r))
  }
}
