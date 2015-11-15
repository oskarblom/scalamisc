package org.oskarblom.scalamisc.httprequest

import java.io.{InputStreamReader, BufferedReader}
import java.net._

/**
  * Created by oskar on 2015/11/08.
  */
object Runner {
  def main(args: Array[String]) {
    val url = new URL("http://unt.se")

    //won't handle http => https redirect - better alternative seems to be apache httpcomponents
    //val url = new URL("http://facebook.com")
    val conn = url.openConnection()
    val httpConnection = conn.asInstanceOf[HttpURLConnection]
    //httpConnection.setRequestMethod("GET")
    httpConnection.setUseCaches(false)
    httpConnection.setDoOutput(true)
    httpConnection.setInstanceFollowRedirects(true)
    val code = httpConnection.getResponseCode()
    val is = httpConnection.getInputStream()
    val reader = new BufferedReader(new InputStreamReader(is))
    val sb = new StringBuilder()
    var line = reader.readLine()


    while(line != null) {
      sb.append(line)
      sb.append('\r')
      line = reader.readLine()
    }
    reader.close()
    val res = sb.toString()
    println("foo main")
  }
}
