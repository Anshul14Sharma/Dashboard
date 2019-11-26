name := "Dashboard"

version := "0.1"

scalaVersion := "2.13.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, SbtTwirl)
//lazy val myProject = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.17"
)

