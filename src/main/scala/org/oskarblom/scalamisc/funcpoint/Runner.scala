package org.oskarblom.scalamisc.funcpoint

/**
  * Created by oskar on 2015/11/14.
  */
object Handlers  {
  def fooHandler(db: String): Unit = {
    println("DB: " + db +  " " + "in statshandler")
  }

  def barHandler(db: String): Unit = {
    println("DB: " + db +  " " + "in dogtaghandler")
  }
}


object Runner {

  val dbs = Seq("table_1_stuff", "table_2_stuff", "table_3_stuff")

  val handlerMapping = Map(
    "gamea" -> ((d: String) => { Handlers.fooHandler(d)}),
    "gameb" -> Handlers.barHandler _
  )

  def main(args: Array[String]) {
    dbs.foreach(handlerMapping("gameb")(_))
  }

}
