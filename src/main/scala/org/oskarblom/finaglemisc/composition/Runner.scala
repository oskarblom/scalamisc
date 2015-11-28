package org.oskarblom.finaglemisc.composition

import com.twitter.util.{Await, Future}

/**
  * Created by oskar on 2015/11/27.
  */
object Runner {

  def fetchUrl(url: String): Future[Array[Byte]] = {
    val html = "<html><head></head><body><img src='myimg.png'></img></body></html>"
    Future.value(html.getBytes())
  }

  def getImageLinks(html: String): Seq[String] = {
    Seq("http://www.google.se/foo.png", "http://www.google.se/bar.png")
  }

  def getImages(): Future[Seq[Array[Byte]]]= {
    val rv = fetchUrl("www.google.com").flatMap(htmlBytes => {
      val links = getImageLinks(htmlBytes.toString)
      val images = links.map(link => {
        fetchUrl(link)
      })
      Future.collect(images)
    })
    rv
  }

  def main(args: Array[String]) {
    val images = getImages()
    val resolvedImages = Await.ready(images)
    ""
  }
}
