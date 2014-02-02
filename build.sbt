name := "study-play-scala"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  // Add your project dependencies here,
  "com.itextpdf" % "itextpdf" % "5.4.5",
  "com.itextpdf" % "itext-asian" % "5.2.0",
  "org.mongodb" %% "casbah" % "2.6.4",
  // for test
  "org.mockito" % "mockito-all" % "1.9.5" % "test",
  "org.specs2" %% "specs2" % "2.3.7" % "test",
  "junit" % "junit" % "4.11" % "test",
  // default
  jdbc,
  anorm,
  cache,
  ws
)

play.Project.playScalaSettings
