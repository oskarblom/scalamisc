package org.oskarblom.scalamisc

import org.oskarblom.scalamisc.testclient.TestClient


/**
  * Created by oskar on 2015/11/07.
  */
object MainRunner {
  def main(args: Array[String]) {
    val client = new TestClient()
    client.doIt()
    println("Hello, scalamisc")
  }
}
