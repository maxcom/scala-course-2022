ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

ThisBuild / scalacOptions ++= Seq(
  "-encoding", "utf8", // Option and arguments on same line
  "-Xfatal-warnings", // New lines for each options
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps",
  "-Yrangepos",
  "-opt:l:inline",
  "-opt-inline-from:**")

val scalatest = "3.2.11"

lazy val root = (project in file("."))
  .settings(
    name := "seminar-future",
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % scalatest,
      "org.scalatest" %% "scalatest" % scalatest % Test,
      "org.scalatestplus" %% "scalacheck-1-15" % s"$scalatest.0" % Test
    )
  )
