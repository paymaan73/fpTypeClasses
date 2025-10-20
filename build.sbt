val scala3Version = "3.7.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "fp",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "org.scalatest" %% "scalatest" % "3.2.19" % Test,
      "org.scalacheck" %% "scalacheck" % "1.17.0" % Test,
      "org.typelevel" %% "cats-core"   % "2.10.0",  // main FP abstractions (Functor, Monad, etc.)
      "org.typelevel" %% "cats-effect" % "3.5.4",   // for IO, concurrency, etc.
      "org.typelevel" %% "cats-free"   % "2.10.0"   // for Free monads, optional
    )
  )
