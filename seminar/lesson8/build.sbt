scalaVersion      := "2.13.7"
name              := "lesson-actor-typed"

val akkaV = "2.6.14"
val actorDependencies = Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaV,
  "com.typesafe.akka" %% "akka-stream" % akkaV,
  "com.typesafe.akka" %% "akka-slf4j" % akkaV,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaV % Test,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "org.mockito" % "mockito-all" % "1.10.19" % Test
)

libraryDependencies ++= actorDependencies

