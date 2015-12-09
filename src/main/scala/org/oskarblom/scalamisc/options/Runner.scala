package org.oskarblom.scalamisc.options

/**
  * Created by oskar on 2015/12/09.
  */
object Runner {

  def runDb(dbName: String) = {

  }

  def main(args: Array[String]) {
    val dbs = Seq("user")
    val db = dbs.find(_ == "user").foreach(runDb)
  }
}
