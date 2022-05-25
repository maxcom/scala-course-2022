ThisBuild / scalaVersion      := "2.13.7"
ThisBuild / version           := "0.1.0-SNAPSHOT"
ThisBuild / organization      := "com.lesson"
ThisBuild / name              := "eleven"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked"
)

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.3.11"

val http4sVersion = "1.0.0-M23"
val circeVersion = "0.14.1"
libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-ember-server" % http4sVersion,
  "org.http4s" %% "http4s-ember-client" % http4sVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "org.mindrot" % "jbcrypt" % "0.3m"
)

