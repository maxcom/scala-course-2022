ThisBuild / scalaVersion      := "2.13.7"
ThisBuild / version           := "0.1.0-SNAPSHOT"
ThisBuild / organization      := "com.lesson"
ThisBuild / name              := "six"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % "0.14.1")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.14.1" % Test,
  "org.typelevel" %% "cats-core" % "2.7.0",
)
