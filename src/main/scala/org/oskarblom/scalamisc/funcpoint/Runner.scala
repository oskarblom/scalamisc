package org.oskarblom.scalamisc.funcpoint

/**
  * Created by oskar on 2015/11/14.
  */
object Handlers  {

  def barHandler = (db: String) => {
    println("DB: " + db +  " " + "in barhandler")
  }

  def fooHandler = (db: String) => {
    println("DB: " + db +  " " + "in foohandler")
  }

}


object Runner {

  val dbs = Seq("table_1_stuff", "table_2_stuff", "table_3_stuff")

  val handlerMapping = Map(
    "a" -> Handlers.barHandler,
    "b" -> Handlers.fooHandler,
  )

  def main(args: Array[String]) {
    dbs.foreach(handlerMapping("a"))
  }
}
