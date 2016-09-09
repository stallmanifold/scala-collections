val scalaz    = "org.scalaz" %% "scalaz-core" % "7.2.6"
val scalactic = "org.scalactic" %% "scalactic" % "3.0.0"
val scalatest = "org.scalatest" %% "scalatest" % "3.0.0" % "test"


lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*)
  .settings(
    name := "nonempty"
  )

libraryDependencies ++= Seq(scalaz, scalactic, scalatest)

scalacOptions += "-feature"

initialCommands in console := "import scalaz._, Scalaz._"
