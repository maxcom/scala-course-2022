scalaVersion      := "2.13.7"
name              := "lesson-json"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.14.1" % Test,
  "com.typesafe.play" %% "play-json" % "2.9.2",
)