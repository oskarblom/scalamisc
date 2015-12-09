package org.oskarblom.scalamisc.finaglehttprequest

import com.twitter.finagle.{http}
import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.builder.ClientBuilder
import com.twitter.util.Await

/**
  * Created by oskar on 2015/11/28.
  */
object HttpClientRunner {
  def main(args: Array[String]): Unit = {
    val client = Http.newService("www.example.com:80")

    val request = http.Request(http.Method.Get, "/")

    request.host = "www.example.com"
    val response = client(request)
    Await.ready(response)
    ""
  }
}
