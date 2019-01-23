name := "MyProject"

version := "0.1"

scalaVersion := "2.12.6"

lazy val root = (project in file(".")).
  settings(
    name := "interactive-classroom-server",
    version := "1.0",
    scalaVersion := "2.12.7",
    libraryDependencies ++= Seq(
      "com.google.firebase" % "firebase-admin" % "6.6.0",
      "com.typesafe" % "config" % "1.3.3"))