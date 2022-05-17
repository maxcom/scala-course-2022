name := "actors-patterns"

version := "0.1"

scalaVersion := "2.13.8"

val akkaV = "2.6.19"
val actorDependencies = Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaV,
  "com.typesafe.akka" %% "akka-slf4j" % akkaV,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaV % Test,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.mockito" % "mockito-all" % "1.10.19" % Test
)


libraryDependencies ++= actorDependencies
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.11"