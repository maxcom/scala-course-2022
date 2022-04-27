ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scala-courses-seminar8"
  )

val AkkaVersion     = "2.6.8"
val AkkaHttpVersion = "10.2.9"
val CirceVersion    = "0.14.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream"          % AkkaVersion,
  "com.typesafe.akka" %% "akka-actor"           % AkkaVersion,
  "com.typesafe.akka" %% "akka-http"            % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit"    % AkkaHttpVersion % Test,
  "com.typesafe.akka" %% "akka-testkit"         % AkkaVersion     % Test,
  "org.scalatest"     %% "scalatest"            % "3.2.11",
  "de.heikoseeberger" %% "akka-http-circe"      % "1.39.2",
  "io.circe"          %% "circe-core"           % CirceVersion,
  "io.circe"          %% "circe-generic"        % CirceVersion,
  "io.circe"          %% "circe-parser"         % CirceVersion
)
