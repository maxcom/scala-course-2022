ThisBuild / scalaVersion      := "2.13.7"
ThisBuild / version           := "0.1.0-SNAPSHOT"
ThisBuild / organization      := "com.lesson"
ThisBuild / name              := "two"

resolvers += "Java.net Maven2 Repository" at "https://repo1.maven.org/maven2/"

enablePlugins(JmhPlugin)
