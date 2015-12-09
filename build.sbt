lazy val root = (project in file(".")).
  settings(
    name := "scalamisc",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "com.twitter" % "finagle-http_2.11" % "6.31.0"
    )
  )


